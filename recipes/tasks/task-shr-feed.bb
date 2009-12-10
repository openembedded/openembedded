DESCRIPTION = "SHR Feed"
PR = "r28"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
		babiloo-efl \
		di \
		dictator \
		dosbox \
		enotes \
		epdfview \
		fbreader \
		ffalarms \
		gpe-calendar \
		gpe-todo \
		gpe-scap \
		gpe-sketchbook \
		gpe-filemanager \
		gpe-gallery \
		gpe-timesheet \
		gpe-contacts \
		gtkmm \
		mc \
		mplayer \
		navit \
		omview \
		python-elementary \
		pythm \
		python-wifi \
		openmoko-agpsui \
		openvpn \
#		shr-config \
		shr-today \
                shr-theme-neo \
		shr-theme-niebiee \
		shr-theme-sixteen \
# gry should be in image already
#		shr-theme-gry \
		shr-splash \
		shr-splash-theme-simple \
		shr-splash-theme-dontpanic \
		shr-splash-theme-handy \
		vagalume \
		x11vnc \

		omoney \
		pyphonelog \
		pingus \
		openmoocow \
		python-pygame \
		mokoko \
		exhibit \
		edje-viewer \
#		obexpush \
#		obexftp \
		mtpaint \
		telepathy-python \
		intone-video \
		ipkg-link \
		ipkg-utils \
		mysql \
		fltk-chess \
		remoko \
		openbmap-logger \
		pisi \
		libnotify \
		accelges \
		ebrainy \
		sms-sentry \
		cellhunter \
		dillo2 \
		usbmode \
		pyefl-sudoku \
		tasks \
		dates \
		omnewrotate \
		xchat \
		python-pyid3lib \
#		libframeworkd-phonegui-efl2 \
		intone \
		vim \
		vpnc \
		emacs \
		mcabber \
		gdb \
		oh-puzzles \
		links-x11 \
		e-wm-illume-dict-pl \
		callrec \
		midori \
		numptyphysics \
		pidgin \
		libpurple-protocol-msn \
		libpurple-protocol-icq \
		vagalume \
		ppp \
#		bluez-hcidump \
		kbdd \
		kexec-tools \
		claws-mail \
		claws-plugin-mailmbox \
#		claws-plugin-gtkhtml2-viewer \
		claws-plugin-rssyl \
		mc \
		iotop \
		xprop \
		xev \
		xwininfo \
		tcpdump \
		lsof \
		zsh \
		gzip \
		zip \
		microcom \
		minicom \
		leafpad \
		abiword \
		aspell \
		enchant \
		joe \
		nano \
		ntpclient \
		ntp \
		tor \
		vnc \
#		gpsdrive \
		wxwidgets \
		x11vnc \
		xf86-video-glamo \
#		libswt3.4-gtk-java \
		cacao \
#		jamvm \
		dbus-x11 \
#		bluez-utils-alsa \
		xournal \
#		evince \
#		asterisk \
		git \
		ruby \
		orrery \
		synergy \
		irssi \
		zhone \
		paroli \
		cu \
		net-tools \
		iproute2 \
		iputils \
		i2c-tools \
		psmisc \
		debianutils \
		tcptraceroute \
		task-proper-tools \
		wmiconfig \
		netkit-telnet \
		bind-utils \
		bubble-keyboard \
		intuition \
		gridpad \
#		essential-dialer \
		font-adobe-100dpi \
		font-adobe-75dpi \
		font-adobe-utopia-100dpi \
		font-adobe-utopia-75dpi \
#		font-adobe-utopia-type1 \
		font-arabic-misc \
		font-bh-100dpi \
		font-bh-75dpi \
		font-bh-lucidatypewriter-100dpi \
		font-bh-lucidatypewriter-75dpi \
#		font-bh-ttf \
#		font-bh-type1 \
		font-bitstream-100dpi \
		font-bitstream-75dpi \
		font-bitstream-speedo \
#		font-bitstream-type1 \
		font-cronyx-cyrillic \
		font-cursor-misc \
		font-daewoo-misc \
		font-dec-misc \
#		font-ibm-type1 \
		font-isas-misc \
		font-jis-misc \
		font-micro-misc \
		font-misc-cyrillic \
#		font-misc-ethiopic \
#		font-misc-meltho \
		font-misc-misc \
		font-mutt-misc \
		font-schumacher-misc \
		font-screen-cyrillic \
		font-sony-misc \
		font-sun-misc \
		font-winitzki-cyrillic \
#		font-xfree86-type1 \
#		msn-pecan \
		qwo \
		fso-apm \
		fso-abyss \
		fsousaged \
		fsodeviced \
		fsonetworkd \
		fsotimed \
		opimd-utils \
		omgps \
		shr-launcher \
		e-tasks \
		elmdentica \
		shr-installer \
		eject \
		illume-keyboard-arabic \
		illume-keyboard-browse \
		illume-keyboard-danish \
		illume-keyboard-default-alt \
		illume-keyboard-dutch \
		illume-keyboard-dvorak \
		illume-keyboard-french \
		illume-keyboard-german \
		illume-keyboard-hebrew \
		illume-keyboard-numeric-alt \
		illume-keyboard-russian \
		illume-keyboard-russian-terminal \
		python-xlib \
		xcompmgr \
		man \
		man-pages \
		aceofpenguins-launcher \
		om-neon \
		ipython \
		phoneme-advanced-foundation \
		eve \
#		python-pybluez \
		x11perf \
		pyring \
		bt-configure \
		bt-gps \
		advancedcaching \
		glamo-dri-tests \
		reiserfsprogs \
		blipomoko \
		imagemagick \
		xboard \
		sox \
		mpg123 \
		zile \
		speex \
		fltkclock \
		fltkhackdiet \
		fltkwwpointcal \
		transmission \
		xf86-input-tslib \
		fltkcocktailbar \
		fltkcurrency \
		mokoeightball \
		babiloo-efl \
		make \
"
