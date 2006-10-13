DESCRIPTION = "xmms plugin for the tremos integer vorbis decoder"
SECTION = "x11/multimedia"
LICENSE = "GPL"
DEPENDS = "xmms tremor"
SRC_URI = "http://mirror1.pdaxrom.org/source/src/xmms-tremor-1.0.tar.bz2"

inherit autotools

FILES_${PN} = "${libdir}/xmms/Input/libxmmstremor.so"
FILES_${PN}-dbg = "${libdir}/xmms/Input/.debug/libxmmstremor.so"

