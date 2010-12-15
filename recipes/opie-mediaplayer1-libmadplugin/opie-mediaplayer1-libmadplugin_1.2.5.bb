require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_multimedia_opieplayer.tar.bz2;name=split_core_multimedia_opieplayer \
	   file://libmadplugin.pro"
SRC_URI[split_core_multimedia_opieplayer.md5sum] = "173a82f9eda1800a394e7596ad13563c"
SRC_URI[split_core_multimedia_opieplayer.sha256sum] = "54f941ae6f8f84482f3c9041a2ae365bcba5dd2e26c57c7376c7d984c86ee7a0"
