require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_i18n.tar.bz2;name=split_i18n \
	   http://sources.openembedded.org/opie-1.2.5-split_etc_dict.tar.bz2;name=split_etc_dict"
SRC_URI[split_i18n.md5sum] = "0877eb0c761b06de8dc64f28d1d4bd6f"
SRC_URI[split_i18n.sha256sum] = "5005fa9825bbbdb10367882ec8a9c2df6e755ecc0c9705e674d4dea00abdea0c"
SRC_URI[split_etc_dict.md5sum] = "1112ee99cf14220ca63ec6c49d4f4e61"
SRC_URI[split_etc_dict.sha256sum] = "43e67873ec83ec33b4ad2d441a8606ac8418ff27581bdffa85eef071bee1f7ce"
