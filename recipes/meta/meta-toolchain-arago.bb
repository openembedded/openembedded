PR = "r3"

SDK_DISTRO = "arago"
TOOLCHAIN_OUTPUTNAME = "${SDK_DISTRO}-${DISTRO_VERSION}-${FEED_ARCH}-${TARGET_OS}-${SDK_SUFFIX}"

TOOLCHAIN_HOST_TASK ?= "task-arago-toolchain-host"
TOOLCHAIN_TARGET_TASK ?= "task-arago-toolchain-target"

TOOLCHAIN_TARGET_EXCLUDE += "\
    libc6 \
    libc6-dev \
    glibc-extra-nss \
    libgcc1 \
    linux-libc-headers-dev \
    libthread-db1 \
    sln \
    curl \
    opkg-nogpg \
    alsa-conf-base \
    update-rc.d \
    update-rc.d-dev \
    tslib-conf \
    pointercal \
    sysvinit \
    sysvinit-inittab \
    i2c-tools \
    mtd-utils \
    util-linux-ng-fdisk \
    util-linux-ng-cfdisk \
    util-linux-ng-sfdisk \
    util-linux-ng-mount \
    util-linux-ng-mountall \
    util-linux-ng-umount \
    util-linux-ng-losetup \
    util-linux-ng-swaponoff \
    util-linux-ng-readprofile \
    util-linux-ng \
    udev-utils \
    "

require meta-toolchain.bb
SDK_SUFFIX = "sdk"
