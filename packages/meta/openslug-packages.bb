DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r3"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_DEVELOPMENT = "\
	autoconf  \
	automake  \
	bash  \
	bison  \
	bzip2  \
	coreutils  \
	cvs \
	diffutils  \
	findutils  \
	flex  \
	gawk \
	gcc  \
	gdb  \
	grep   \
	lsof  \
	m4  \
	make  \
	ncurses  \
	openssh  \
	pciutils  \
	perl  \
	quilt  \
	sed  \
	strace  \
	tar thttpd  \
	"


OPENSLUG_PACKAGES = "\
	atftp \
	bash \
	bluez-utils-nodbus \
	coreutils cvs\
	miau \
	microcom \
	mt-daapd \
	muxsshssl \
	nail \
	openssh \
	ppp puppy \
	rsync \
	strace sudo \
	thttpd \
	"

BROKEN_PACKAGES = "\
	mgetty \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT}'
