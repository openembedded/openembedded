DESCRIPTION = "snort - a free lightweight network intrusion detection system for UNIX and Windows."
HOMEPAGE = "http://www.snort.org/"
LICENSE = "GPL"
DEPENDS = "libpcap libpcre libprelude"

PR = "r3"

SRC_URI = " ${GENTOO_MIRROR}/${P}.tar.gz;name=tarball \
            file://snort.fix.configure.in.HACK;apply=yes \
            file://snort.init \
	    file://default \
            file://logrotate \
	    file://volatiles \
          "
SRC_URI[tarball.md5sum] = "ef02aaad54746603f2cb3236fe962128"
SRC_URI[tarball.sha256sum] = "a7d9eb16427514d00926e9892c4a92b6ff1fd0f79555d8f8dce91dfa14112e6a"

S = "${WORKDIR}/${P}"

#snort does not like parallel make!
PARALLEL_MAKE = ""
EXTRA_OECONF = " \
	--enable-decoder-preprocessor-rules \
	--enable-gre \
	--enable-linux-smp-stats \
	--enable-prelude \
	--enable-reload \
	--enable-reload-error-restart \
	--enable-targetbased \
	"

inherit autotools pkgconfig

#fix path of pc file
do_install_prepend() {
	sed -i -e 's:-Wl,-rpath-link,${STAGING_LIBDIR}::g' -e 's:-isystem${STAGING_INCDIR}::g'  snort.pc
}

do_install_append() {
	install -d ${D}/${sysconfdir}/snort/rules
	install -d ${D}/${sysconfdir}/snort/preproc_rules
	install -d ${D}/${sysconfdir}/default/volatiles
	mkdir -p ${D}/${sysconfdir}/init.d
	for i in map config conf dtd; do
		cp ${S}/etc/*.$i ${D}/${sysconfdir}/snort/
	done
	cp ${S}/preproc_rules/*.rules ${D}/${sysconfdir}/snort/preproc_rules/
	install -m 0644 ${WORKDIR}/default ${D}/${sysconfdir}/default/snort
	install -m 0644 ${WORKDIR}/volatiles ${D}/${sysconfdir}/default/volatiles/snort
	install -m 0755 ${WORKDIR}/snort.init ${D}/${sysconfdir}/init.d/snort
	mkdir -p ${D}/${localstatedir}/log/snort
	install -d ${D}${sysconfdir}/logrotate.d
	install -m 0644 ${WORKDIR}/logrotate ${D}${sysconfdir}/logrotate.d/snort
}

pkg_postinst_${PN}() {
	grep -q ^snort: /etc/group || addgroup snort
	grep -q ^snort: /etc/passwd || \
		adduser --disabled-password --home=/var/log/snort/ --system \
			--ingroup snort --no-create-home -g "snort" snort
	${sysconfdir}/init.d/populate-volatile.sh update
}

PACKAGES =+ "${PN}-logrotate"
FILES_${PN}-logrotate = "${sysconfdir}/logrotate.d/snort"
FILES_${PN} += " \
	${libdir}/snort_dynamicengine/*.so.* \
	${libdir}/snort_dynamicpreprocessor/*.so.* \
	${libdir}/snort_dynamicrules/*.so.* \
	"
FILES_${PN}-dbg += " \
	${libdir}/snort_dynamicengine/.debug \
	${libdir}/snort_dynamicpreprocessor/.debug \
	${libdir}/snort_dynamicrules/.debug \
	"
FILES_${PN}-static += " \
	${libdir}/snort_dynamicengine/*.a \
	${libdir}/snort_dynamicpreprocessor/*.a \
	${libdir}/snort_dynamicrules/*.a \
	"
FILES_${PN}-dev += " \
	${libdir}/snort_dynamicengine/*.la \
	${libdir}/snort_dynamicpreprocessor/*.la \
	${libdir}/snort_dynamicrules/*.la \
	${libdir}/snort_dynamicengine/*.so \
	${libdir}/snort_dynamicpreprocessor/*.so \
	${libdir}/snort_dynamicrules/*.so \
	${prefix}/src/snort_dynamicsrc \
	"

RRECOMMENDS_${PN} += "${PN}-logrotate"
RRECOMMENDS_${PN} += "barnyard"
RSUGGESTS_${PN}-logrotate += "logrotate"
