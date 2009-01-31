require samba.inc
require samba-basic.inc

SRC_URI += "file://configure.patch;patch=1 \
            file://cifs.patch;patch=1"

PR = "r5"

EXTRA_OECONF += "\
                 --without-ads"

do_compile () {
        oe_runmake proto_exists
        base_do_compile
        ${CC} client/mount.cifs.c -o mount.cifs
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
