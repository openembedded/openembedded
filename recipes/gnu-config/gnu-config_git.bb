DESCRIPTION = "The GNU config.guess and config.sub scripts"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = ""
INHIBIT_DEFAULT_DEPS = "1"

PR = "r1"
FAKESRCREV="e35217687ee5f39b428119fe31c7e954f6de64f0"
PR_append = "+gitr${FAKESRCREV}"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/git_git.savannah.gnu.org.config.git_${FAKESRCREV}.tar.gz \
           file://config-guess-uclibc.patch \
           file://gnu-configize.in"

SRC_URI[md5sum] = "6a45979aa33d15b23c874b95e24c8732"
SRC_URI[sha256sum] = "a83bf7c7c972eb4106b5d7c6126d3b5b058f7aace7a62cae4e4f330d62f40259"

S = "${WORKDIR}/git"

do_compile() {
	:
}

do_install () {
	install -d ${D}${datadir}/gnu-config \
		   ${D}${bindir}
	cat ${WORKDIR}/gnu-configize.in | \
		sed -e 's,@gnu-configdir@,${datadir}/gnu-config,g' \
		    -e 's,@autom4te_perllibdir@,${datadir}/autoconf,g' > ${D}${bindir}/gnu-configize
	# In the native case we want the system perl as perl-native can't have built yet
	if [ "${BUILD_ARCH}" != "${TARGET_ARCH}" ]; then
		cat ${WORKDIR}/gnu-configize.in | \
			sed -e 's,/usr/bin/env,${bindir}/env,g' > ${D}${bindir}/gnu-configize
	fi
	chmod 755 ${D}${bindir}/gnu-configize
	install -m 0644 config.guess config.sub ${D}${datadir}/gnu-config/
}

FILES_${PN} = "${bindir} ${datadir}/gnu-config"

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"

