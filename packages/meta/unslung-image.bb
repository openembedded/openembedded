# Put the standard image last, so that the kernel modules that are built will work on both.
DEPENDS = "unslung-able-image unslung-standard-image"
EXCLUDE_FROM_WORLD = "1"
