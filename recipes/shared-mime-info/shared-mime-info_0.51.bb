require shared-mime-info.inc

LICENSE = "GPLv2"

DEPENDS = "libxml2 intltool-native glib-2.0 shared-mime-info-native"
PR = "r3"

do_install_append() {
    update-mime-database ${D}${datadir}/mime
}

# freedesktop.org.xml is huge and only needed when updating the db
# mime.bbclass will add the dependency on it automagically
PACKAGES =+ "freedesktop-mime-info"
FILES_freedesktop-mime-info = "${datadir}/mime/packages/freedesktop.org.xml"
RDEPENDS_freedesktop-mime-info = "shared-mime-info"


SRC_URI[md5sum] = "01d72161f7d88123fbccd378871f02f0"
SRC_URI[sha256sum] = "1c247e03418d6b90bcbc0da6c1abe6ac9cd5bacf9c3a2f3b6105376cf7b0eed8"
