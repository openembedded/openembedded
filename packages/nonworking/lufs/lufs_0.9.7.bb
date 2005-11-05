DESCRIPTION=Linux Userland File Systems
SECTION=base
PRIORITY=optional
LICENSE=GPL

SRC_URI = ${SOURCEFORGE_MIRROR}/lufs/lufs-${PV}.tar.gz
S = ${WORKDIR}/lufs-${PV}

inherit autotools

KERNEL_VERSION=`cat ${STAGING_DIR}/target/kernel/kernel-version`
KERNEL_SOURCE=`cat ${STAGING_DIR}/target/kernel/kernel-source`
KERNEL_PATH=${STAGING_DIR}/target/kernel

EXTRA_OECONF = --with-kernel=${KERNEL_VERSION} --with-kheaders=${STAGING_DIR}/target/kernel/include

