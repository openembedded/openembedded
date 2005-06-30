PREFIX = /usr
PACKAGE = xdemineur
DEBUG = no
CVSBUILD = no
VERSION = 0.28

MEMBERS = demineur main xdemineur util
LINGUAS = 

PACKAGE_CPPFLAGS += $(STANDARD_CPPFLAGS)
PACKAGE_CFLAGS += $(STANDARD_CFLAGS)
PACKAGE_LDFLAGS += $(STANDARD_LDFLAGS) -lX11 -lXpm

DEPS = $(patsubst %,%.d,$(MEMBERS))
OBJS = $(patsubst %,%.o,$(MEMBERS))
SOURCES = $(patsubst %,%.c,$(MEMBERS))

all: xdemineur

xdemineur: $(OBJS)
	$(CC) -o $@ $^ $(LDFLAGS) $(PACKAGE_LDFLAGS)

install: all
	install -d $(DESTDIR)$(PREFIX)/bin
	install -s xdemineur $(DESTDIR)$(PREFIX)/bin/xdemineur
	install -D -m 644 xdemineur.xpm $(DESTDIR)$(PREFIX)/share/pixmaps/xdemineur.xpm
	install -D -m 644 familiar/xdemineur.png $(DESTDIR)$(PREFIX)/share/pixmaps/xdemineur.png
	install -d $(DESTDIR)$(PREFIX)/share/applications
	install -m 644 familiar/$(PACKAGE).desktop $(DESTDIR)$(PREFIX)/share/applications/
