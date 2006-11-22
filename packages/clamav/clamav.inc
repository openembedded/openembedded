DESCRIPTION = "Clam AntiVirus is a GPL anti-virus toolkit for UNIX. The main \
purpose of this software is the integration with mail servers (attachment \
scanning)."
DESCRIPTION_${PN}-lib = "The dynamic library that is shared between all of \
the Clam AntiVirus components"
DESCRIPTION_${PN}-freshclam = "An automatic virus signature update \
application for Clam AntiVirus"
DESCRIPTION_${PN}-data = "Static antivirus signature database for Clam AntiVirus"
DESCRIPTION_${PN}-daemon = "An on-demand file scanning service for Clam AntiVirus"
HOMEPAGE = "http://www.clamav.net/"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "zlib bzip2 gmp"
RDEPENDS_${PN} = "${PN}-data"
RDEPENDS_${PN}-daemon = "${PN}-data"
RRECOMMENDS_${PN} = "${PN}-freshclam"
RRECOMMENDS_${PN}-daemon = "${PN}-freshclam"

SRC_URI = "${SOURCEFORGE_MIRROR}/clamav/clamav-${PV}.tar.gz \
          file://cross-compile-fix.patch;patch=1 \
          file://libtool-fix.patch;patch=1 \
          file://clamav-daemon.init \
          file://clamav-freshclam.init \
          file://clamav-daemon.default \
          file://clamd.conf \
          file://freshclam.conf \
          file://volatiles.02_clamav-data \
          file://volatiles.03_clamav-daemon \
          file://volatiles.03_clamav-freshclam"

inherit autotools update-rc.d binconfig

# Don't check for clamav uid/gid - they don't exist on the host
# Put virus definitions in /var/lib not /usr/lib
EXTRA_OECONF = "--disable-clamav \
                --with-dbdir=${localstatedir}/lib/clamav"

do_install_append() {
        install -m 0755 -d ${D}${sysconfdir}/default/volatiles \
                           ${D}${sysconfdir}/init.d ${D}${docdir}/clamav

        # Save the installed clamd.conf in the doc dir and then install our new one
        install -m 0755 ${D}${sysconfdir}/clamd.conf ${D}${docdir}/clamav/clamd.conf.example
        install -m 0755 ${WORKDIR}/clamd.conf ${D}${sysconfdir}/clamd.conf

        # Save the installed freshclam.conf in the doc dir and then install our new one
        install -m 0755 ${D}${sysconfdir}/freshclam.conf ${D}${docdir}/clamav/freshclam.conf.example

        # Install our config files and init scripts
        install -m 0755 ${WORKDIR}/freshclam.conf ${D}${sysconfdir}/freshclam.conf
        install -m 0755 ${WORKDIR}/clamav-daemon.default ${D}${sysconfdir}/default/clamav-daemon
        install -m 0755 ${WORKDIR}/clamav-daemon.init ${D}${sysconfdir}/init.d/clamav-daemon
        install -m 0755 ${WORKDIR}/clamav-freshclam.init ${D}${sysconfdir}/init.d/clamav-freshclam

        # We need some /var directories
        for i in 02_clamav-data 03_clamav-daemon 03_clamav-freshclam; do
          install -m 0644 ${WORKDIR}/volatiles.$i ${D}${sysconfdir}/default/volatiles/$i
        done

        # Move the clamav data to a non-volatile location, we'll symlink back
        # If freshclam is running it'll break the link to this static data
        # once it has succesfully downloaded an update
        install -m 0755 -d ${D}${libdir}
        mv ${D}${localstatedir}/lib/clamav ${D}${libdir}
}
do_stage () {
        oe_libinstall -a -so libclamav ${STAGING_LIBDIR}
        rm -f ${STAGING_LIBDIR}/libclamav.la
        install -m 0644 libclamav/clamav.h ${STAGING_INCDIR}
}

PACKAGES += "${PN}-freshclam ${PN}-daemon ${PN}-data ${PN}-lib"

FILES_${PN} = "${bindir}/clamscan ${bindir}/sigtool ${bindir}/clamdscan"
FILES_${PN}-lib = "${libdir}/libclamav.so.*"
FILES_${PN}-freshclam = "${bindir}/freshclam \
                         ${sysconfdir}/freshclam.conf \
                         ${sysconfdir}/init.d/clamav-freshclam \
                         ${sysconfdir}/default/volatiles/03_clamav-freshclam"
FILES_${PN}-daemon = "${sysconfdir}/clamd.conf \
                      ${sbindir}/clamd \
                      ${sysconfdir}/init.d/clamav-daemon \
                      ${sysconfdir}/default/clamav-daemon \
                      ${sysconfdir}/default/volatiles/03_clamav-daemon"
FILES_${PN}-data = "${libdir}/clamav/main.cvd \
                    ${libdir}/clamav/daily.cvd \
                    ${sysconfdir}/default/volatiles/02_clamav-data"
FILES_${PN}-dev += "${bindir}/clamav-config"

# Add clamav's user and groups
pkg_postinst_${PN}-freshclam () {
        grep -q clamav: /etc/group || addgroup clamav
        grep -q clamav: /etc/passwd || \
            adduser --disabled-password --home=/var/lib/clamav/ --system \
                    --ingroup clamav --no-create-home -g "ClamAV" clamav
        /etc/init.d/populate-volatile.sh update
}
pkg_postinst_${PN}-daemon () {
        grep -q clamav: /etc/group || addgroup clamav
        grep -q clamav: /etc/passwd || \
            adduser --disabled-password --home=/var/lib/clamav/ --system \
                    --ingroup clamav --no-create-home -g "ClamAV" clamav
        /etc/init.d/populate-volatile.sh update
}
pkg_postinst_${PN}-data () {
        grep -q clamav: /etc/group || addgroup clamav
        grep -q clamav: /etc/passwd || \
            adduser --disabled-password --home=/var/lib/clamav/ --system \
                    --ingroup clamav --no-create-home -g "ClamAV" clamav
        /etc/init.d/populate-volatile.sh update
}

# Indicate that the default files are configuration files
CONFFILES_${PN}-daemon = "${sysconfdir}/clamd.conf \
                          ${sysconfdir}/default/clamav-daemon"
CONFFILES_${PN}-freshclam = "${sysconfdir}/freshclam.conf"

INITSCRIPT_PACKAGES = "${PN}-daemon ${PN}-freshclam"
INITSCRIPT_NAME_${PN}-daemon = "clamav-daemon"
INITSCRIPT_NAME_${PN}-freshclam = "clamav-freshclam"
INITSCRIPT_PARAMS_${PN}-daemon = "defaults 50 50"
INITSCRIPT_PARAMS_${PN}-freshclam = "defaults 50 50"
