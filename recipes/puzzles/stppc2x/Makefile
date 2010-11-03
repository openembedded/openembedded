PROGRAM_NAME = stppc2x

COMBINED = -DCOMBINED 
# -DSTYLUS_BASED

OBJ_SUFFIX = .o

INCS = $(COMBINED) -Wall -Werror -Wno-char-subscripts
LIBS = -L. -lSDL -lSDL_gfx -lSDL_ttf -lSDL_image -ljpeg -lpng -lz -lpthread $(COMBINED)
# -lSDL_mixer

.PHONY  :  clean
.PHONY  :  all

all: 
	$(MAKE) executables

executables:	blackbox$(OBJ_SUFFIX) bridges$(OBJ_SUFFIX) combi$(OBJ_SUFFIX) cube$(OBJ_SUFFIX) dictionary$(OBJ_SUFFIX) divvy$(OBJ_SUFFIX) \
		dominosa$(OBJ_SUFFIX) drawing$(OBJ_SUFFIX) dsf$(OBJ_SUFFIX) fastevents$(OBJ_SUFFIX) fifteen$(OBJ_SUFFIX) filling$(OBJ_SUFFIX) \
		flip$(OBJ_SUFFIX) galaxies$(OBJ_SUFFIX) grid$(OBJ_SUFFIX) guess$(OBJ_SUFFIX) inertia$(OBJ_SUFFIX) iniparser$(OBJ_SUFFIX) \
		keen$(OBJ_SUFFIX) latin$(OBJ_SUFFIX) laydomino$(OBJ_SUFFIX) lightup$(OBJ_SUFFIX) list$(OBJ_SUFFIX) loopy$(OBJ_SUFFIX) magnets$(OBJ_SUFFIX) map$(OBJ_SUFFIX) \
		maxflow$(OBJ_SUFFIX) maze3d$(OBJ_SUFFIX) maze3dc$(OBJ_SUFFIX) midend$(OBJ_SUFFIX) mines$(OBJ_SUFFIX) misc$(OBJ_SUFFIX) \
		mosco$(OBJ_SUFFIX) net$(OBJ_SUFFIX) netslide$(OBJ_SUFFIX) pattern$(OBJ_SUFFIX) pegs$(OBJ_SUFFIX) random$(OBJ_SUFFIX) range$(OBJ_SUFFIX) rect$(OBJ_SUFFIX) \
		samegame$(OBJ_SUFFIX) sdl$(OBJ_SUFFIX) signpost$(OBJ_SUFFIX) singles$(OBJ_SUFFIX) sixteen$(OBJ_SUFFIX) slant$(OBJ_SUFFIX) slide$(OBJ_SUFFIX) smalloc$(OBJ_SUFFIX) \
		sokoban$(OBJ_SUFFIX) solo$(OBJ_SUFFIX) tents$(OBJ_SUFFIX) towers$(OBJ_SUFFIX) tree234$(OBJ_SUFFIX) twiddle$(OBJ_SUFFIX) unequal$(OBJ_SUFFIX) \
		untangle$(OBJ_SUFFIX) version$(OBJ_SUFFIX)
	$(CC) -o $(PROGRAM_NAME) blackbox$(OBJ_SUFFIX) bridges$(OBJ_SUFFIX) combi$(OBJ_SUFFIX) cube$(OBJ_SUFFIX) dictionary$(OBJ_SUFFIX) \
		divvy$(OBJ_SUFFIX) dominosa$(OBJ_SUFFIX) drawing$(OBJ_SUFFIX) dsf$(OBJ_SUFFIX) fastevents$(OBJ_SUFFIX) fifteen$(OBJ_SUFFIX) \
		filling$(OBJ_SUFFIX) flip$(OBJ_SUFFIX) galaxies$(OBJ_SUFFIX) grid$(OBJ_SUFFIX) guess$(OBJ_SUFFIX) inertia$(OBJ_SUFFIX) \
		iniparser$(OBJ_SUFFIX) keen$(OBJ_SUFFIX) latin$(OBJ_SUFFIX) laydomino$(OBJ_SUFFIX) lightup$(OBJ_SUFFIX) list$(OBJ_SUFFIX) loopy$(OBJ_SUFFIX) magnets$(OBJ_SUFFIX) map$(OBJ_SUFFIX) \
		maxflow$(OBJ_SUFFIX) maze3d$(OBJ_SUFFIX) maze3dc$(OBJ_SUFFIX) midend$(OBJ_SUFFIX) mines$(OBJ_SUFFIX) misc$(OBJ_SUFFIX) mosco$(OBJ_SUFFIX) \
		net$(OBJ_SUFFIX) netslide$(OBJ_SUFFIX) pattern$(OBJ_SUFFIX) pegs$(OBJ_SUFFIX) random$(OBJ_SUFFIX) range$(OBJ_SUFFIX) rect$(OBJ_SUFFIX) samegame$(OBJ_SUFFIX) \
		sdl$(OBJ_SUFFIX) signpost$(OBJ_SUFFIX) singles$(OBJ_SUFFIX) sixteen$(OBJ_SUFFIX) slant$(OBJ_SUFFIX) slide$(OBJ_SUFFIX) smalloc$(OBJ_SUFFIX) sokoban$(OBJ_SUFFIX) \
		solo$(OBJ_SUFFIX) tents$(OBJ_SUFFIX) towers$(OBJ_SUFFIX) tree234$(OBJ_SUFFIX) twiddle$(OBJ_SUFFIX) unequal$(OBJ_SUFFIX) untangle$(OBJ_SUFFIX) \
                version$(OBJ_SUFFIX) $(LDFLAGS) $(LIBS)

blackbox$(OBJ_SUFFIX): ./blackbox.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

bridges$(OBJ_SUFFIX): ./bridges.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

combi$(OBJ_SUFFIX): ./combi.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

cube$(OBJ_SUFFIX): ./cube.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

dictionary$(OBJ_SUFFIX): ./dictionary.c ./dictionary.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

divvy$(OBJ_SUFFIX): ./divvy.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

dominosa$(OBJ_SUFFIX): ./dominosa.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

drawing$(OBJ_SUFFIX): ./drawing.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

dsf$(OBJ_SUFFIX): ./dsf.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

fastevents$(OBJ_SUFFIX): ./fastevents.c ./fastevents.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

fifteen$(OBJ_SUFFIX): ./fifteen.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

filling$(OBJ_SUFFIX): ./filling.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

flip$(OBJ_SUFFIX): ./flip.c ./puzzles.h ./tree234.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

galaxies$(OBJ_SUFFIX): ./galaxies.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

grid$(OBJ_SUFFIX): ./grid.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

guess$(OBJ_SUFFIX): ./guess.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

inertia$(OBJ_SUFFIX): ./inertia.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

iniparser$(OBJ_SUFFIX): ./iniparser.c ./iniparser.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

keen$(OBJ_SUFFIX): ./keen.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

latin$(OBJ_SUFFIX): ./latin.c ./puzzles.h ./tree234.h ./maxflow.h ./latin.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

laydomino$(OBJ_SUFFIX): ./laydomino.c
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

lightup$(OBJ_SUFFIX): ./lightup.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

list$(OBJ_SUFFIX): ./list.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

loopy$(OBJ_SUFFIX): ./loopy.c ./grid.h ./puzzles.h ./tree234.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

magnets$(OBJ_SUFFIX): ./magnets.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

map$(OBJ_SUFFIX): ./map.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

maxflow$(OBJ_SUFFIX): ./maxflow.c ./maxflow.h ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

maze3d$(OBJ_SUFFIX): maze3d.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

maze3dc$(OBJ_SUFFIX): maze3dc.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

midend$(OBJ_SUFFIX): ./midend.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

mines$(OBJ_SUFFIX): ./mines.c ./tree234.h ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

misc$(OBJ_SUFFIX): ./misc.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

mosco$(OBJ_SUFFIX): ./mosco.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

net$(OBJ_SUFFIX): ./net.c ./puzzles.h ./tree234.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

netslide$(OBJ_SUFFIX): ./netslide.c ./puzzles.h ./tree234.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

pattern$(OBJ_SUFFIX): ./pattern.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

pegs$(OBJ_SUFFIX): ./pegs.c ./puzzles.h ./tree234.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

random$(OBJ_SUFFIX): ./random.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

rect$(OBJ_SUFFIX): ./rect.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

range$(OBJ_SUFFIX): ./range.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

samegame$(OBJ_SUFFIX): ./samegame.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

sdl$(OBJ_SUFFIX): ./sdl.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

signpost$(OBJ_SUFFIX): ./signpost.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

singles$(OBJ_SUFFIX): ./singles.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

sixteen$(OBJ_SUFFIX): ./sixteen.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

slant$(OBJ_SUFFIX): ./slant.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

slide$(OBJ_SUFFIX): ./slide.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

smalloc$(OBJ_SUFFIX): ./smalloc.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

sokoban$(OBJ_SUFFIX): ./sokoban.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

solo$(OBJ_SUFFIX): ./solo.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

tents$(OBJ_SUFFIX): ./tents.c ./puzzles.h ./maxflow.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

towers$(OBJ_SUFFIX): ./towers.c ./puzzles.h ./tree234.h ./maxflow.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

tree234$(OBJ_SUFFIX): ./tree234.c ./tree234.h ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

twiddle$(OBJ_SUFFIX): ./twiddle.c ./puzzles.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

unequal$(OBJ_SUFFIX): ./unequal.c ./puzzles.h ./latin.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

untangle$(OBJ_SUFFIX): ./untangle.c ./puzzles.h ./tree234.h 
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

version$(OBJ_SUFFIX): ./version.c ./version.def
	$(CC) $(CFLAGS) `cat version.def` -c version.c -o $@

windows$(OBJ_SUFFIX): ./windows.c ./puzzles.h ./resource.h
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

install:
	install -d $(DESTDIR)/usr/bin
	install -d $(DESTDIR)/usr/share/pixmaps
	install -d $(DESTDIR)/usr/share/applications
	install -d $(DESTDIR)/usr/share/games/stppc2x/help
	install -d $(DESTDIR)/usr/share/games/stppc2x/images
	install -d $(DESTDIR)/usr/share/games/stppc2x/licenses
	install -d $(DESTDIR)/usr/share/games/stppc2x/screenshots

	install -m 0755 stppc2x $(DESTDIR)/usr/bin
	install -m 0644 *.sav $(DESTDIR)/usr/share/games/stppc2x
	install -m 0644 credits.txt $(DESTDIR)/usr/share/games/stppc2x
	install -m 0644 stppc2x.data $(DESTDIR)/usr/share/games/stppc2x
	install -m 0644 help/*.txt $(DESTDIR)/usr/share/games/stppc2x/help
	install -m 0644 images/*.png $(DESTDIR)/usr/share/games/stppc2x/images
	install -m 0644 images/stppc2x.gif $(DESTDIR)/usr/share/games/stppc2x/images
	install -m 0644 licences/* $(DESTDIR)/usr/share/games/stppc2x/licenses
	install -m 0644 screenshots/* $(DESTDIR)/usr/share/games/stppc2x/screenshots

clean:
	rm *.o
	rm stppc2x
