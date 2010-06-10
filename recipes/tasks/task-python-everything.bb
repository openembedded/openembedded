DESCRIPTION= "Everything Python"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PV = "2.6"
PR = "ml45"

RDEPENDS_${PN} = "\
  python-ao \
  python-cheetah \
  python-coherence \
  python-connexion \
  python-constraint \
  python-daap \
  python-dbus \
  python-dialog \
  python-docutils \
  python-dweba \
  task-python-efl \
  task-python-efl-examples \
  python-fam \
  python-flup \
  python-fnorb\
  python-formencode \
  python-fpconst \
  python-fugrep \
  python-fuse \
  python-fusil \
#  python-gammu \
  python-gmpy \
  python-gnosis	\
  python-gst \
  python-imaging \
  python-imdbpy	\
  python-inotify \
  python-irclib	\
  python-logilab-common	\
  python-libgmail \
  python-m2crypto \
  python-mad \
  python-mako \
  python-netfilter \
  python-numarray \
  python-numeric \
  python-numpy \
  python-ogg \
  python-opendir \
  python-pexpect \
# only on x86
#  python-psyco \
  python-ptrace \
  python-pyalsa \
  python-pyalsaaudio \
  python-pybluez \
  python-pycairo \
  python-pychecker \
  python-pycodes \
  python-pycrypto \
  python-pycurl \
  python-pyephem \
  python-pyfits \
  python-pyflakes \
  python-pyftpdlib \
  python-pygame \
  python-pygobject \
  python-pygoogle \
  python-pygtk-1.2 \
  python-pygtk \
  python-pyid3lib \
  python-pylinda \
  python-pylint \
  python-pylirc \
  python-pymetar \
  python-pymp3 \
  python-pyode \
  python-pyopenssl \
  python-pyqt \
  python-pyraf \
  python-pyrex \
  python-pyrtc \
  python-pyro \
  python-pyserial \
  python-pysqlite2 \
  python-pytester \
  python-pyusb \
  python-pyvisa \
  python-pyweather \
  python-pyxdg \
  python-pyxml \
  python-pyxmlrpc \
  python-pyyaml \
  python-pyzeroconf \
  python-rpyc \
  python-scapy \
  python-scons \
  python-setuptools \
  python-simplejson \
  python-sip \
  python-sgmlop	\
  python-soappy	\
  python-sphinx \
  python-sphinxsearch \
  python-spydi \
  python-sqlalchemy \
  python-sqlobject \
  python-traits \
  python-tlslite \
  python-twisted \
  python-vorbis	\
  python-webpy \
  python-xappy \
  python-xlib \
  \
  dtn \
  iotop \
  moin \
  plone	\
  zope \
  zope-interfaces \
"
