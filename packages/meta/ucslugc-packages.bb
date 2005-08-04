# Meta package containing all the packages which build for UcSlugC
#
# All packages in here must build with the ucslugc.conf distro, they
# do not necessarily work.
DESCRIPTION = "Packages that are compatible with the UcSlugC firmware"
LICENSE = MIT
PR = "r0"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

# The list of packages to build for the ucslugc DISTRO.
# KEEP IN ALPHABETICAL ORDER
UCSLUGC_PACKAGES = "\
	atftp \
	autoconf \
	automake \
	bash \
	bind \
	binutils \
	bison \
	bluez-utils-nodbus \
	bridge-utils \
	bwmon \
	bzip2 \
	ccxstream \
	coreutils \
	cron \
	cvs \
	cvs\
	cyrus-imapd \
	db4 \
	diffutils \
	dnsmasq \
	expat \
	findutils \
	flex \
	ftpd-topfield \
	gawk \
	gcc \
	gdb \
	glib-2.0 \
	gnu-config \
	gphoto2 \
	grep \
	gtk-doc \
	gzip \
	ipkg-utils \
	jpeg \
	less \
	libpng \
	libtool \
	libusb \
	libxml2 \
	lsof \
	m4 \
	make \
	mgetty \
	miau \ 
	microcom \
	monotone-4 monotone-5 \
	mpd \
	mt-daapd \
	mutt \
	mysql \
	nail \
	nano \
	ncftp \
	ncurses \
	netpbm \
	ntp \
	obexftp openobex openobex-apps ircp \
	openldap \
	openntpd \
	openssh \
	openvpn \
	patch \
	pciutils \
	pcre \
	perl \
	pkgconfig \
	ppp \
	procps \
	puppy \
	pwc \
	python \
	quilt \
	reiserfsprogs reiser4progs \
	rsync \
	samba \
	sane-backends \
	sed \
	setpwc \
	strace \
	streamripper \
	sudo \
	sysfsutils \
	tar \
	thttpd \
	tiff \
	unionfs-modules unionfs-utils \
	util-linux \
	vlan \
	wakelan \
	wget \
	zlib \
	"

# These packages only build on TARGET_OS=linux, but not TARGET_OS=linux-uclibc.
# KEEP IN ALPHABETICAL ORDER
UCSLUGC_BROKEN_PACKAGES = "\
	man man-pages \
	php \
	psmisc \
	screen \
	timezones \
	xinetd \
	"

# These packages will never build because uclibc lacks (and always will lack)
# appropriate support.  This define is for documentation of this fact!
UCSLUGC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	nfs-utils \
	postfix \
	yp-tools ypbind ypserv \
	"

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "openslug-image ${UCSLUGC_PACKAGES} package-index"
