require samba.inc
inherit update-rc.d

PR = "r2"

SRC_URI += "file://config-lfs.patch;patch=1 \
	   file://init \
           file://quota.patch;patch=1;pnum=0 \
	   file://cifs.patch;patch=1 \
	   "

INITSCRIPT_NAME = "samba"
# No dependencies, goes in at level 20 (NOTE: take care with the
# level, later levels put the shutdown later too - see the links
# in rc6.d, the shutdown must precede network shutdown).
INITSCRIPT_PARAMS = "defaults"
CONFFILES_${PN} = "${sysconfdir}/samba/smb.conf"

# The file system settings --foodir=dirfoo and overridden unconditionally
# in the samba config by --with-foodir=dirfoo - even if the --with is not
# specified!  Fix that here.  Set the privatedir to /etc/samba/private.
EXTRA_OECONF += "\
	samba_cv_struct_timespec=yes \
	--with-configdir=${sysconfdir}/samba \
	--with-privatedir=${sysconfdir}/samba/private \
	--with-lockdir=${localstatedir}/lock \
	--with-piddir=${localstatedir}/run \
	--with-logfilebase=${localstatedir}/log \
	--with-libdir=${libdir} \
	--with-mandir=${mandir} \
	--with-swatdir=${datadir}/swat \
	"

do_install_append() {
	install -d "${D}${localstatedir}/log"
	rm -f ${D}/sbin/mount.smbfs
	ln -sf smbmount ${D}${sbindir}/mount.smbfs
	install -d "${D}${sysconfdir}/init.d"
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/samba
	install -d "${D}${sysconfdir}/samba"
	install -c -m 644 ../examples/smb.conf.default ${D}${sysconfdir}/samba/smb.conf
}

PACKAGES =+ "swat"

FILES_swat = "${sbindir}/swat ${datadir}/swat ${libdir}/*.msg"
FILES_${PN} += "${libdir}/vfs/*.so ${libdir}/charset/*.so ${libdir}/*.dat ${libdir}/auth/*.so"
#
# bug fix for samba.inc:
FILES_cifs-doc += "${mandir}/man8/mount.cifs.8"
