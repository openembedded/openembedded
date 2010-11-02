DESCRIPTION = "Initialization and startup scripts for felix on BUG"
LICENSE = "MIT"
PR = "r0"
RDEPENDS+="update-rc.d"

SRC_URI = "file://config.properties \
            file://start.sh \
            file://felix \
            file://felix-debug"

framedir = "/usr/share/java"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${framedir}/start.sh \
                ${framedir}/conf/config.properties \
                /etc/init.d/felix \
                /etc/init.d/felix-debug \
                "

DEPENDS = "fastjar-native felix"

do_compile() {
	echo "bug.os.version=${DISTRO_VERSION}" >> ${WORKDIR}/config.properties
}

addtask init_install before do_package after do_install
do_init_install() {
        install -m 0755 -d ${D}${framedir}
        install -m 0755 -d ${D}${framedir}/conf
        install -m 0755 ${WORKDIR}/start.sh ${D}${framedir}
        install -m 0755 ${WORKDIR}/config.properties ${D}${framedir}/conf/
        install -d ${D}/etc
        install -d ${D}/etc/init.d
        install -m 0755 ${WORKDIR}/felix ${D}/etc/init.d
        install -m 0755 ${WORKDIR}/felix-debug ${D}/etc/init.d
}

inherit update-rc.d

INITSCRIPT_NAME = "felix"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 30 0 1 6 ."

pkg_postrm_${PN}() {
	update-rc.d -f felix remove
}
