SOURCES = argsresources.c \
caps.c \
colour.c \
cursor.c \
desktop.c \
dialogs.c \
fullscreen.c \
listen.c \
misc.c \
popup.c \
rfbproto.c \
selection.c \
shm.c \
sockets.c \
tunnel.c \
vncviewer.c \
../libvncauth/vncauth.c \
../libvncauth/d3des.c

tightvncviewer : $(SOURCES)
	$(CC) $(CFLAGS) $(LDFLAGS) -I. -I../include -I../libvncauth/ -lX11 -lXaw -ljpeg -lz -o tightvncviewer $(SOURCES)

