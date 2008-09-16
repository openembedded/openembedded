# Extended Beagleboard demo image containing Jalimo stuff.

require beagleboard-demo-image.bb

IMAGE_INSTALL += "\
    phoneme-advanced-foundation \
    cacao \
    libswt3.4-gtk-java \
    libdbus-java \
    midpath-openmoko \
"
