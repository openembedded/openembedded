require openttd.inc

PR = "r2"

SRC_URI_append_shr = " file://openttd.cfg"

do_install_append_shr() {
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/openttd.cfg ${D}${datadir}/games/openttd/data/
}

SRC_URI[md5sum] = "30763b0dc6d77386a23261ad4b2cded8"
SRC_URI[sha256sum] = "014286af4b978fec3845fe276d40d07789acd4ac67b5f489f9bdfdf0eed6ad27"
