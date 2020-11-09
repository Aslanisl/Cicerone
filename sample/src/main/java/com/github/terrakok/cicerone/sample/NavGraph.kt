package com.github.terrakok.cicerone.sample

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.terrakok.cicerone.graph.*
import com.github.terrakok.cicerone.sample.ui.graph.ForkFragment
import com.github.terrakok.cicerone.sample.ui.graph.RoadFragment


fun Graph() = graph {
    edges = {
        dest("1") {
            screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
            edges = {
                dest("2") {
                    screen = { id -> FragmentScreen(id) { ForkFragment.getNewInstance(id) } }
                    edges = {
                        dest("3") {
                            screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                            edges = {
                                dest("4") {
                                    screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                                    edges = {
                                        edge("5")
                                    }
                                }
                            }
                        }
                        dest("5") {
                            screen = { id -> FragmentScreen(id) { ForkFragment.getNewInstance(id) } }
                            edges = {
                                dest("6") {
                                    screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                                }
                                dest("7") {
                                    screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                                    jumps = {
                                        finish("1")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        dest("8") {
            screen = { id -> FragmentScreen(id) { ForkFragment.getNewInstance(id) } }
            edges = {
                dest("9") {
                    screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                    edges = {
                        edge("1")
                    }
                    jumps = {
                        jump("1") {
                            backTo = ROOT_ID
                            chain = listOf("1", "2", "3", "4", "5", "7")
                        }
                    }
                }
                dest("10") {
                    screen = { id -> FragmentScreen(id) { ForkFragment.getNewInstance(id) } }
                    edges = {
                        dest("11") {
                            screen = { id -> FragmentScreen(id) { RoadFragment.getNewInstance(id) } }
                        }
                        edge("10")
                    }
                }
            }
        }
    }
}