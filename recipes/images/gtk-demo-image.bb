export IMAGE_BASENAME = "gtk-demo-image"

DEPENDS = "task-boot"
IMAGE_INSTALL = "\
    task-boot \
    dropbear \
    xauth \
    gtk+ \
    gtk+-demo \
    "

inherit image
