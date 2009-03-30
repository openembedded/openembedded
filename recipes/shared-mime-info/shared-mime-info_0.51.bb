require shared-mime-info.inc

DEPENDS = "libxml2 intltool-native glib-2.0 shared-mime-info-native"
PR = "r2"

do_install_append() {
    update-mime-database ${D}${datadir}/mime
}

# freedesktop.org.xml is huge and only needed when updating the db
# mime.bbclass will add the dependency on it automagically
PACKAGES =+ "freedesktop-mime-info"
FILES_freedesktop-mime-info = "${datadir}/mime/packages/freedesktop.org.xml"
RDEPENDS_freedesktop-mime-info = "shared-mime-info"

