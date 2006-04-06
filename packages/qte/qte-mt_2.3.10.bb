require qte-common_${PV}.inc

PR = "r0"

EXTRA_OECONF = "-system-jpeg -system-libpng -system-zlib -no-qvfb -no-xft -no-vnc -gif -thread -static \
		-xplatform ${TARGET_OS}-${QTE_ARCH}-g++ ${EXTRA_OECONF_CONFIG} -depths 8,16,32"
export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"
#export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -fvisibility=hidden -DGCC_SUPPORTS_VISIBILITY -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
