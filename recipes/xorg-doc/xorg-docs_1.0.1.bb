require xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

PE = "1"

FILES_${PN} += " /usr/share/X11/doc"


SRC_URI[archive.md5sum] = "78fd95f6d5ea69d91723dcc16280c664"
SRC_URI[archive.sha256sum] = "b7b8593b055e29dedc0631e1db9781583038afc67bce0f715fdf3201570d1e4e"
