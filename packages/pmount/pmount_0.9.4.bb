DESCRIPTION="mount removable devices as normal user"
DEPENDS="sysfsutils"
PR="r1"

SRC_URI="http://www.piware.de/projects/pmount-0.9.4.tar.gz \
	 file://mmc-fix.patch;patch=1 \
	 file://no-hal.patch;patch=1"

do_install() {
	install -m 4755 -D ${S}/pmount ${D}/${bindir}/pmount
        install -m 4755 -D ${S}/pumount ${D}/${bindir}/pumount
        install -m 644 -D ${S}/pmount.1 ${D}/${datadir}/man/man1/pmount.1
	install -m 644 -D ${S}/pumount.1 ${D}/${datadir}/man/man1/pumount.1
	install -m 644 -D ${S}/pmount.allow ${D}/${sysconfdir}/pmount.allow
}
