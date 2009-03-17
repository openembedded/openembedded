DESCRIPTION = "Task mamona: Window Manager"
LICENSE = "MIT"
PR = "r2"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
    task-mamona \
    e-wm \
    libmamona-im-ecore \
    libmamona-im-gtk \
    pango-module-basic-x \
    pango-module-basic-fc \
    aterm \
    midori \
"
