DECODERS_TO_BUILD=decoders/vorbis.so decoders/flac.so decoders/mpg123.so
FRONTENDS_TO_BUILD=frontends/sdl.so frontends/log.so
CC=$(CC)
CXX=$(CPP)
STRIP=$(STRIP)
DEVICE=UNKNOWN_SYSTEM

SDL_LIB=$(shell sdl-config --libs)
SDL_CFLAGS=$(shell sdl-config --cflags)

INCS=$(CFLAGS) $(SDL_CFLAGS) -fsigned-char -D_REENTRANT -DUSE_MEMORY_H -D_$(DEVICE)
LIBS=$(LDFLAGS) $(SDL_LIB) -lSDL_image -lSDL_gfx -ldl -Wl,-export-dynamic
