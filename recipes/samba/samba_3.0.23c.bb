require samba.inc
require samba-basic.inc

SRC_URI += "file://configure.patch;patch=1 \
            file://cifs.patch;patch=1"

PR = "r7"

EXTRA_OECONF += "\
	--with-smbmount \
	"

PACKAGES =+ " smbfs smbfs-doc"
RCONFLICTS_smbfs-doc = "smbfs-ads-doc"
FILES_smbfs = "${bindir}/smbmount ${bindir}/smbumount ${bindir}/smbmnt ${base_sbindir}/mount.smbfs ${base_sbindir}/mount.smb"
FILES_smbfs-doc = "${mandir}/man8/smbmount.8 ${mandir}/man8/smbumount.8 ${mandir}/man8/smbmnt.8"

do_compile () {
        oe_runmake proto_exists
        base_do_compile
        ${CC} client/mount.cifs.c -o mount.cifs
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}

SRC_URI[src.md5sum] = "9e06d5e10f4ae84f7fafad75d1b4184c"
SRC_URI[src.sha256sum] = "f333051eadf6ae88c30bd3d62eb94e9d6cf4a21912c4923d6ffddb029a42631c"
