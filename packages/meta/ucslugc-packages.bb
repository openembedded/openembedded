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
	audiofile \
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
	diffstat \
	diffutils \
	dnsmasq \
	expat \
	findutils \
	flac \
	flex \
	ftpd-topfield \
	gawk \
	gcc \
	gdb \
	gdbm \
	glib-2.0 \
	gnu-config \
	gphoto2 \
	grep \
	gtk-doc \
	gzip \
	ipkg-utils \
	jpeg \
	less \
	libao \
	libid3tag \
	libmad \
	libmikmod \
	libogg \
	libpng \
	libtool \
	libusb \
	libvorbis \
	libxml2 \
	lrzsz \
	lsof \
	m4 \
	make \
	mgetty \
	miau \ 
	microcom \
	monotone-4 \
	monotone-5 \
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
	python-core \
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
	iperf \
	man man-pages \
	php \
	psmisc \
	screen \
	timezones \
	xinetd \
	"

# These packages have problems with thumb or thumb-interwork compilation - they
# should really be fixed (if still in the build it is because there is a hacky
# work round.)  The problem here is that _call_via_r2 is apparently inaccessible
# under some circumstances.
THUMB_BROKEN_PACKAGES = "\
	"

# These packages will never build because uclibc lacks (and always will lack)
# appropriate support.  This define is for documentation of this fact!  The
# normal cause is that the package uses the "NIS" interfaces (once known as
# YP - a trademark of BT which SUN used without license - the missing function
# calls often still have 'yp' in the name).
UCSLUGC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	nfs-utils \
	postfix \
	yp-tools ypbind ypserv \
	"

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "openslug-image ${UCSLUGC_PACKAGES} openslug-native package-index"
