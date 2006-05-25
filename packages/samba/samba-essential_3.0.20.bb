PR = "r1"

SRC_URI = "http://us2.samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://cifs.patch;patch=1 \
	   file://config-lfs.patch;patch=1 \
	   file://init \
           file://quota.patch;patch=1;pnum=0 \
	   file://smb-essential.conf \
	   file://Managing-Samba.txt"
	   
S := ${WORKDIR}/samba-${PV}/source

RCONFILCTS = samba

include samba-essential.inc
inherit update-rc.d

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
	--with-configdir=${sysconfdir}/samba \
	--with-privatedir=${sysconfdir}/samba/private \
	--with-lockdir=${localstatedir}/lock \
	--with-piddir=${localstatedir}/run \
	--with-logfilebase=${localstatedir}/log \
	--with-libdir=${libdir} \
	--with-mandir=${mandir} \
	"

do_install_append() {
	install -d "${D}${localstatedir}/log"
	rm -f ${D}/sbin/mount.smbfs
	rmdir ${D}/sbin
	install -d "${D}${sysconfdir}/init.d"
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/samba
	
	install -d "${D}${sysconfdir}/samba"	
	install -d "${D}/usr/share/samba/help"	
	
	install ${WORKDIR}/smb-essential.conf "${D}${sysconfdir}/samba/smb.conf"
	install ${WORKDIR}/Managing-Samba.txt  ${D}/usr/share/samba/help
	
}

FILES_${PN} = "${bindir}/smbpasswd \	       
	       ${sbindir}/nmbd \
	       ${sbindir}/smbd \
	       ${libdir}/charset \
	       ${libdir}/vfs \
	       ${libdir}/*.dat \
	       /usr/share/samba \
	       /etc"
