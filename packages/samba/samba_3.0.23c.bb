require samba.inc

PR = "r4"

SRC_URI += "file://cifs.patch;patch=1 \
                "

EXTRA_OECONF += "\
                 --without-ads \
	         "

do_compile () {
        oe_runmake proto_exists
        base_do_compile
        ${CC} client/mount.cifs.c -o mount.cifs
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
