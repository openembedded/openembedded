DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native glib-2.0"
PR = "r1"

inherit autotools pkgconfig gpe

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libmimedir-utils"
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"

SRC_URI[md5sum] = "f1e314b35923a3786e4f32b75d3d605a"
SRC_URI[sha256sum] = "dbe106443b7221b50bd50fe9463fe233dbaf6ee15f052cceedd382dedd021510"
