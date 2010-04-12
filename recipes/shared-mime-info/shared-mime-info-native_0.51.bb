require shared-mime-info.inc

DEPENDS = "libxml2-native intltool-native glib-2.0-native"

inherit native

S = "${WORKDIR}/shared-mime-info-${PV}"

SRC_URI[md5sum] = "01d72161f7d88123fbccd378871f02f0"
SRC_URI[sha256sum] = "1c247e03418d6b90bcbc0da6c1abe6ac9cd5bacf9c3a2f3b6105376cf7b0eed8"
