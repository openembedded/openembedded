DESCRIPTION = "xmms plugin for the mad integer mp3 decoder"
SECTION = "x11/multimedia"
HOMEPAGE = "http://xmms-mad.sourceforge.net"
LICENSE = "GPL"
DEPENDS = "xmms libmad libid3tag"
SRC_URI = "${SOURCEFORGE_MIRROR}/xmms-mad/xmms-mad-${PV}.tar.bz2"

inherit autotools

export XMMS_CONFIG = "${STAGING_BINDIR_CROSS}/xmms-config"

FILES_${PN} = "${libdir}/xmms/Input/libxmmsmad.so"
FILES_${PN}-dbg += "${libdir}/xmms/Input/.debug/libxmmsmad.so"


SRC_URI[md5sum] = "410b30968bdb4adce0baec8acc7f2ed4"
SRC_URI[sha256sum] = "c0c89d93442c85296386199dc08a8ad9b480a29deea31936e5688c2bcc9a5265"
