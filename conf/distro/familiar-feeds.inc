DISTRO_FEED_PREFIX = "http://ftp.handhelds.org/distributions/familiar/releases/${DISTRO_VERSION}/feed"

DISTRO_FEEDS_prepend () {
# Familiar ${DISTRO_VERSION} feeds

# base - essential packages
src/gz base ${DISTRO_FEED_PREFIX}/base
src/gz base-${MACHINE} ${DISTRO_FEED_PREFIX}/base/machine/${MACHINE}

# updates - security and bugfix updates go in this feed
src/gz updates ${DISTRO_FEED_PREFIX}/updates
src/gz updates-${MACHINE} ${DISTRO_FEED_PREFIX}/updates/machine/${MACHINE}

# common - additional packages not specific to any graphical environment
src/gz common ${DISTRO_FEED_PREFIX}/common
src/gz common-${MACHINE} ${DISTRO_FEED_PREFIX}/common/machine/${MACHINE}
}

DISTRO_LOCALE_FEEDS_PREFIXES = "${DISTRO_FEED_PREFIX}/base ${DISTRO_FEED_PREFIX}/updates ${DISTRO_FEED_PREFIX}/common"

DISTRO_LOCALE_FEEDS_HEADER_prepend () {
# Familiar ${DISTRO_VERSION} locale feeds

}
