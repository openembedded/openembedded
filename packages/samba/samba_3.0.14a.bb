PR = "r1"

SRC_URI := "http://us2.samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
	   file://${FILESDIR}/configure.patch;patch=1 \
	   file://${FILESDIR}/cifs.patch;patch=1"
S := ${WORKDIR}/${P}/source

include samba.inc

EXTRA_OECONF += "--with-mandir=${mandir}"

do_install_append() {
	rm -f ${D}/sbin/mount.smbfs
	rmdir ${D}/sbin
	ln -sf smbmount ${D}${bindir}/mount.smbfs
}

PACKAGES =+ "swat"

FILES_swat = "${sbindir}/swat ${prefix}/swat ${libdir}/*.msg"
FILES_${PN} += "${libdir}/vfs/*.so ${libdir}/charset/*.so ${libdir}/*.dat"
