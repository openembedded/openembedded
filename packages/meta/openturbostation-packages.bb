DESCRIPTION = "Packages that are compatible with Openturbostation"
LICENSE = "MIT"
PR = "r1"
CONFLICTS = "db3"
PROVIDES += "${OPENTURBOSTATION_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"

OPENTURBOSTATION_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	apache2 \
	audiofile \
	aumix \
	autoconf \
	automake \
	bash \
	bind \
	binutils \
	bison \
	bridge-utils \
	bzip2 \
	ccxstream \
	cdparanoia \
	cdstatus \
	coreutils \
	cron \
	ctorrent \
	cvs \
	db \
	devlabel \
	diffstat \
	diffutils \
	dnsmasq \
	e2fsprogs \
	e2fsprogs-libs \
	expat \
	ez-ipupdate \
	fetchmail \
	file \
	findutils \
	flex \
	flite \
	gallery \
	gawk \
	gdbm \
	gnu-config \
	grep \
	gtk-doc \
	gzip \
	hdparm \
	ipkg-utils \
	iptables \
	ircp \
	joe \
	jpeg \
	less \
	libao \
	libid3tag \
	liblockfile \
	libmad \
	libmikmod \
	libogg \
	libol \
	libpng \
	libtool \
	libupnp \
	libusb \
	libvorbis \
	litestream \
	lrzsz \
	lsof \
	lvm2 \
	m4 \
	madplay \
	mailx \
	make \
	mdadm \
	mgetty \
	miau \
	microcom \
	minicom \
	modphp \
	mt-daapd \
	mtd-utils \
	mutt \
	nail \
	nano \
	ncftp \
	ncurses \
	netcat \
	nmap \
	ntp \
	openobex-apps \
	openldap \
	openntpd \
	openobex \
	openssh \
	openvpn \
	patch \
	pciutils \
	libpcre \
	perl \
	pkgconfig \
	ppp \
	procps \
	quilt \
	rng-tools \
	rsync \
	sed \
	setserial \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sysfsutils \
	syslog-ng \
	tar \
	thttpd \
	tiff \
	unzip \
	usbutils \
	util-linux \
	vim \
	vlan \
	watchdog \
	wget \
	zip \
	zlib \
	"

OPENTURBOSTATION_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
# openprotium-native \
DEPENDS = "\
	openturbostation-image \
	${OPENTURBOSTATION_PACKAGES} \
	${OPENTURBOSTATION_EXTRA_PACKAGES} \
	package-index \
	"
