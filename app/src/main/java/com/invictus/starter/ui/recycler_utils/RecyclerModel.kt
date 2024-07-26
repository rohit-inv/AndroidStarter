package com.invictus.starter.ui.recycler_utils

interface RecyclerModel {
    override fun equals(other: Any?): Boolean

    /**
     * Called to check whether two objects represent the same item.
     * For example, if your items have unique ids, this method should check their id equality.
     * Note: null items in the list are assumed to be the same as another null item and are assumed to not be the same as a non-null item. This callback will not be invoked for either of those cases.
     * */
    fun areItemsTheSame(other: RecyclerModel): Boolean =
        javaClass == other.javaClass && this == other

    /**
     *
     * Called to check whether two items have the same data.
     * This information is used to detect if the contents of an item have changed.
     * This method to check equality instead of Object. equals(Object) so that you can change its behavior depending on your UI
     * */
    fun areContentsTheSame(other: RecyclerModel): Boolean =
        javaClass == other.javaClass && this == other
}