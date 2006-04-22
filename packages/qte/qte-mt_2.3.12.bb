require qte-common_${PV}.inc
PR = "r0"

EXTRA_OECONF += "-thread"
export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"
#export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -fvisibility=hidden -DGCC_SUPPORTS_VISIBILITY -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
