SRC_URI += "file://config-lfs.patch;patch=1 \
            file://quota.patch;patch=1;pnum=0 \
            "

EXTRA_OECONF += "\
        --without-ads \
        --without-winbind \
        --without-ldap \
        --without-krb5"

PACKAGES =+ "libsmbclient libsmbclient-dev cifs cifs-doc smbfs swat"

RCONFLICTS_${PN} = "samba-ads"
RCONFLICTS_libsmbclient = "libsmbclient-ads"
RCONFLICTS_libsmbclient-dev = "libsmbclient-ads-dev"
RCONFLICTS_cifs = "cifs-ads"
RCONFLICTS_cifs-doc = "cifs-ads-doc"
RCONFLICTS_smbfs = "smbfs-ads"
RCONFLICTS_swat = "swat-ads"

FILES_cifs = "${base_sbindir}/mount.cifs ${base_sbindir}/umount.cifs"
FILES_cifs-doc = "${mandir}/man8/mount.cifs.8 ${mandir}/man8/umount.cifs.8"
FILES_libsmbclient = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-dev = "${libdir}/libsmbclient.so ${includedir}"
FILES_smbfs = "${bindir}/smbmount ${bindir}/smbumount ${bindir}/smbmnt ${base_sbindir}/mount.smbfs ${base_sbindir}/mount.smb"
FILES_swat       = "${sbindir}/swat ${datadir}/swat ${libdir}/*.msg"
