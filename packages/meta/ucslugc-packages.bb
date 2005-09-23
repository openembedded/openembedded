# Meta package containing all the packages which build for UcSlugC
#
# All packages in here must build with the ucslugc.conf distro, they
# do not necessarily work.
DESCRIPTION = "Packages that are compatible with the UcSlugC firmware"
LICENSE = MIT
PR = "r1"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

# The list of packages to build for the ucslugc DISTRO.
# KEEP IN ALPHABETICAL ORDER
UCSLUGC_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	atftp \
	audiofile \
	autoconf \
	automake \
	bash \
	bind \
	binutils \
	bison \
	bluez-utils-nodbus \
	boost \
	bridge-utils \
	bwmon \
	bzip2 \
	ccxstream \
	coreutils \
	cron \
	cvs \
	cvs\
	db4 \
	diffstat \
	diffutils \
	dnsmasq \
	expat \
	file \
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
	libgphoto2 \
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
	mpd \
	mt-daapd \
	mutt \
	nail \
	nano \
	ncftp \
	ncurses \
	netpbm \
	nmap \
	ntp \
	obexftp openobex openobex-apps ircp \
	openldap \
	openntpd \
	openssh \
	openvpn \
	patch \
	pciutils \
	pcre \
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
	vim \
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

# These packages are not in the build because they have a significant compilation
# time and probably aren't very useful on a ucslugc system
THUMB_OPTIONAL_PACKAGES = "\
	monotone-4 \
	mysql \
	"

# These packages have problems with thumb or thumb-interwork compilation - they
# should really be fixed (if still in the build it is because there is a hacky
# work round.)  The problem with monotone-5 is that it is simply too big.
# The problem with perl is that it links a .so without explicitly including
# libgcc.a or crti.o - consequently the .so does not have a set of _call_via_rX
# functions to call...
THUMB_BROKEN_PACKAGES = "\
	monotone-5 \
	perl \
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
DEPENDS = "openslug-image ${UCSLUGC_PACKAGES} ucslugc-native package-index"
