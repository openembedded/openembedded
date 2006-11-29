DESCRIPTION = "xmms plugin for the mad integer mp3 decoder"
SECTION = "x11/multimedia"
HOMEPAGE = "http://xmms-mad.sourceforge.net"
LICENSE = "GPL"
DEPENDS = "xmms libmad libid3tag"
SRC_URI = "${SOURCEFORGE_MIRROR}/xmms-mad/xmms-mad-${PV}.tar.bz2"

inherit autotools

export XMMS_CONFIG = "${STAGING_BINDIR_CROSS}/xmms-config"

FILES_${PN} = "${libdir}/xmms/Input/libxmmsmad.so"
FILES_${PN}-dbg = "${libdir}/xmms/Input/.debug/libxmmsmad.so"

