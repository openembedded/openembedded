DESCRIPTION = "Allows applications compiled with 2.95 to run on a 3.x compiled \
system by providing 2.95 libraries. To run compatible programs, use the Compat \
Library program in the Settings menu to make them use these libraries."
SECTION = "opie/settings"
PRIORITY = "optional"
DEPENDS = "opie-sh"
RDEPENDS = "opie-sh"
RPROVIDES = "oz-compat"
RCONFLICTS = "oz-compat"
MAINTAINER = "Tim Ansell <mithro AT mithis.net>"
LICENSE = "GPL"
PR = "r2"

EXCLUDE_FROM_SHLIBS = "1"
COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "http://openzaurus.org/mirror/oz-compat_0.5.tar.gz \
	   file://hentges.patch;patch=1 \
	   file://qt2310.patch;patch=1"

S = "${WORKDIR}/oz-compat-0.5"

inherit update-rc.d

INITSCRIPT_NAME = "quickexec"
INITSCRIPT_PARAMS = "defaults 10"

do_install() {
	install -d ${D}${palmtopdir}/apps/Settings
	install -d ${D}${palmtopdir}/bin/
	install -d ${D}${palmtopdir}/etc/
	install -d ${D}${palmtopdir}/pics/
	
	install -d ${D}/opt/QtPalmtop.compat/bin
	install -d ${D}/opt/QtPalmtop.compat/binlib
	install -d ${D}/opt/QtPalmtop.compat/lib
	
	install -d ${D}${sysconfdir}/init.d
	
	install -m 0644 ${WORKDIR}/oz-compat-0.5/opt/QtPalmtop/apps/Settings/makecompat.desktop ${D}${palmtopdir}/apps/Settings		
	install -m 0644 ${WORKDIR}/oz-compat-0.5/opt/QtPalmtop/etc/quickexec.libs ${D}${palmtopdir}/etc/quickexec.libs
	install -m 0644 ${WORKDIR}/oz-compat-0.5/opt/QtPalmtop/pics/libraries.png ${D}${palmtopdir}/pics/libraries.png
	
	install -m 0755 ${WORKDIR}/oz-compat-0.5/opt/QtPalmtop.compat/bin/* ${D}/opt/QtPalmtop.compat/bin
	install -m 0644 ${WORKDIR}/oz-compat-0.5/opt/QtPalmtop.compat/lib/* ${D}/opt/QtPalmtop.compat/lib
	
	install -m 0755 ${WORKDIR}/oz-compat-0.5/etc/init.d/quickexec ${D}${sysconfdir}/init.d
			
	cd ${D}${palmtopdir}/bin
	for file in chkhinge makecompat qeserver quickexec runcompat
	do
		ln -s /opt/QtPalmtop.compat/bin/$file
	done
	
	cd ${D}/opt/QtPalmtop.compat/lib
	ln -s libqpe.so.1.5.0 libqpe.so.1.5
	ln -s libqpe.so.1.5.0 libqpe.so.1
	ln -s libqpe.so.1.5.0 libqpe.so
	
	ln -s libqte.so.2.3.7 libqte.so.2.3.2
	ln -s libqte.so.2.3.7 libqte.so.2.3	
	ln -s libqte.so.2.3.7 libqte.so.2
	ln -s libqte.so.2.3.7 libqte.so
		
	
}

pkg_postinst() {
test -n "$D" && exit 1

# needed for update-rc.d
test -e /media/card/etc/init.d/quickexec && ln -s /media/card/etc/init.d/quickexec /etc/init.d/quickexec
test -e /media/cf/etc/init.d/quickexec && ln -s /media/cf/etc/init.d/quickexec /etc/init.d/quickexec
test -e /media/ram/etc/init.d/quickexec && ln -s /media/ram/etc/init.d/quickexec /etc/init.d/quickexec
}

pkg_postrm() {
	test -e /etc/init.d/quickexec && rm /etc/init.d/quickexec
}

FILES_${PN} += "/opt /etc"
LEAD_SONAME = "libqte.so.*"
