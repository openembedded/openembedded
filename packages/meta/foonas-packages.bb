DESCRIPTION = "Packages that are compatible with FooNAS"
LICENSE = "MIT"
PR = "r2"
CONFLICTS = "db3"
PROVIDES += "${FOONAS_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"

inherit meta

FOONAS_PACKAGES = "\
	adns \
	alsa-lib \
	alsa-utils \
	apache2 \
	asterisk \
	audiofile \
	aumix \
	autoconf \
	automake \
	bash \
	bash-completion \
	bc \
	beep \
	bind \
	binutils \
	bison \
	bridge-utils \
	bonnie++ \
	bzflag \
	bzip2 \
	ccxstream \
	cdparanoia \
	cdstatus \
	cherokee \
	chillispot \
	coreutils \
	cpusage \
	cpuspeed \
	cron \
	ctorrent \
	cvs \
	dash \
	db \
	dbench \
	devlabel \
	dhcpcd \
	dialog \
	diffstat \
	diffutils \
	dircproxy \
	dnsmasq \
	dosfstools \
	e2fsprogs \
	e2fsprogs-libs \
	e2tools \
	eb \
	ebtables \
	elvis \
	expat \
	ez-ipupdate \
	fetchmail \
	file \
	findutils \
	flex \
	flite \
	gawk \
	gcc \
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
	postgresql \
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
	tzdata \
	tiff \
	unzip \
	usbutils \
	util-linux \
	vim \
	vlan \
	watchdog \
	wget \
	wireless-tools \
	zip \
	zlib \
	"

FOONAS_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "\
	foonas-image \
	${FOONAS_PACKAGES} \
	${FOONAS_EXTRA_PACKAGES} \
	package-index \
	"
