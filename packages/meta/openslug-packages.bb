DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r2"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_PACKAGES = "\
	atftp \
	bash \
	bluez-utils-nodbus \
	coreutils \
	miau \
	microcom \
	mgetty \
	mt-daapd \
	muxsshssl \
	nail \
	openssh \
	ppp puppy \
	strace sudo \
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES}'
