# a tiny compile is without Neogeo games

ASTEROID=1
#TEMPEST=1
GALAGA=1
CENTIPED=1
#JOUST=1

## all games, obtained by :
# nm xmame.x11 | fgrep " driver_"|awk '{print $3}' |sed -e s/driver_// > allgames
## list all clones:
# ./xmame.x11 -listclones|awk '{print $1}'|sort |uniq > allclones
# sed `cat allclones |sed -e 's/^/-e s@^/' -e 's/$/$@@/'` < allgames > allbutclones

GAMES = 4in1 8ball 8ballact ad2083 alibaba amidar anteater armorcar atlantis azurian bagman bigbucks blkhole bongo botanic bwcasino calipso cannonb catapult cavelon cavenger cclimber checkman chewing ckong conquer cosmos crush darkplnt darkwar dazzler dealer devilfsh diggerc dingo dingoe dkong dkong3 dkongjr dorodon drakton dremshpr drivfrcp eggor eyes frogger galaxian gmgalax goldbug guzzler harem heartatk hero hotshock hunchbak huncholy hustler igmo jumpbug jumpshot kingball ladybug levers lizwiz logger losttomb luctoday mariner mario mars megadon mimonkey minefld moonal2 mooncrst moonqsr moonwar mrkougar mrtnt mshuttle mspacman newsin7 nmouse orbitron ozon1 pacplus phoenix pickin pisces pleiads ponpoko porky puckman racknrol radarscp radarzon raiders redclash redufo rescue revenger rockclim rocktrv2 rpatrolb sbagman scobra scorpion scramble sfx shootbul shootgal skybase snapjack spacefrt spcfrcii spclforc spdcoin sraider stratgyx streakng strtheat superbik superbon suprglob survival swimmer tazmania theend triplep trvchlng turtles uniwars vanvan wallst warofbug woodpek zerohour zigzag

comma:= ,
empty:=
space:= $(empty) $(empty)
COREDEFS += -DTINY_NAME="$(subst $(space),$(comma),$(patsubst %,driver_%,$(GAMES)))"
COREDEFS += -DTINY_POINTER="$(subst $(space),$(comma),$(patsubst %,&driver_%,$(GAMES)))"

# uses these CPUs
CPUS+=Z80@
CPUS+=8085A@
CPUS+=M6502@
CPUS+=N2A03@
CPUS+=I8035@
CPUS+=I8039@
CPUS+=S2650@

# uses these SOUNDs
SOUNDS+=DAC@
SOUNDS+=SAMPLES@
SOUNDS+=CUSTOM@

# basic set: pacman + dkong + galaxian + mario ...
SOUNDS+=AY8910@
SOUNDS+=NAMCO@
SOUNDS+=SN76496@
SOUNDS+=TMS5110@
SOUNDS+=NES@
SOUNDS+=TMS36XX@
SOUNDS+=DISCRETE@
OBJS = \
	$(OBJ)/vidhrdw/pacman.o $(OBJ)/drivers/pacman.o \
	$(OBJ)/machine/mspacman.o $(OBJ)/machine/pacplus.o \
	$(OBJ)/machine/jumpshot.o $(OBJ)/machine/theglobp.o \
	$(OBJ)/machine/acitya.o \
	$(OBJ)/drivers/epos.o $(OBJ)/vidhrdw/epos.o \
	$(OBJ)/vidhrdw/dkong.o $(OBJ)/sndhrdw/dkong.o $(OBJ)/drivers/dkong.o \
	$(OBJ)/machine/strtheat.o $(OBJ)/machine/drakton.o \
	$(OBJ)/machine/scramble.o $(OBJ)/sndhrdw/scramble.o $(OBJ)/drivers/scramble.o \
	$(OBJ)/drivers/frogger.o \
	$(OBJ)/drivers/scobra.o \
	$(OBJ)/drivers/amidar.o \
	$(OBJ)/vidhrdw/galaxian.o $(OBJ)/sndhrdw/galaxian.o $(OBJ)/drivers/galaxian.o \
	$(OBJ)/vidhrdw/cclimber.o $(OBJ)/sndhrdw/cclimber.o $(OBJ)/drivers/cclimber.o \
	$(OBJ)/drivers/cvs.o $(OBJ)/vidhrdw/cvs.o $(OBJ)/vidhrdw/s2636.o \
	$(OBJ)/vidhrdw/mario.o $(OBJ)/sndhrdw/mario.o $(OBJ)/drivers/mario.o \
	$(OBJ)/machine/bagman.o $(OBJ)/vidhrdw/bagman.o $(OBJ)/drivers/bagman.o \
	$(OBJ)/vidhrdw/phoenix.o $(OBJ)/sndhrdw/phoenix.o $(OBJ)/drivers/phoenix.o \
	$(OBJ)/sndhrdw/pleiads.o \
	$(OBJ)/vidhrdw/ladybug.o $(OBJ)/drivers/ladybug.o \
	$(OBJ)/vidhrdw/redclash.o $(OBJ)/drivers/redclash.o \
	$(OBJ)/machine/8255ppi.o $(OBJ)/machine/7474.o \
	$(OBJ)/vidhrdw/res_net.o \

ifdef ASTEROID
GAMES += astdelux asteroid llander
SOUNDS+=POKEY@
OBJS += \
	$(OBJ)/machine/atari_vg.o \
	$(OBJ)/machine/asteroid.o $(OBJ)/sndhrdw/asteroid.o \
	$(OBJ)/sndhrdw/llander.o $(OBJ)/drivers/asteroid.o \
	$(OBJ)/vidhrdw/avgdvg.o \

ifdef TEMPEST
GAMES += esb starwars tempest
SOUNDS+=TMS5220@
OBJS += \
	$(OBJ)/machine/mathbox.o \
	$(OBJ)/drivers/tempest.o \
	$(OBJ)/machine/starwars.o \
	$(OBJ)/drivers/starwars.o $(OBJ)/sndhrdw/starwars.o \
	$(OBJ)/machine/slapstic.o \

endif
endif

ifdef GALAGA
GAMES += bosco digdug galaga xevious
SOUNDS+=NAMCO_52XX@
SOUNDS+=NAMCO_54XX@
OBJS += \
	$(OBJ)/vidhrdw/bosco.o \
	$(OBJ)/vidhrdw/galaga.o $(OBJ)/drivers/galaga.o \
	$(OBJ)/vidhrdw/digdug.o \
	$(OBJ)/vidhrdw/xevious.o $(OBJ)/machine/xevious.o \
	$(OBJ)/machine/namcoio.o \

endif

ifdef CENTIPED
GAMES += bullsdrt centiped milliped warlords
OBJS += \
	$(OBJ)/vidhrdw/centiped.o $(OBJ)/drivers/centiped.o \
	$(OBJ)/machine/random.o \

endif

ifdef JOUST
GAMES += blaster bubbles colony7 defender inferno jin joust joust2 lottofun mayday mysticm playball robotron sinistar spdball splat stargate tshoot
CPUS+=M6809@
CPUS+=M6808@
SOUNDS+=YM2151@
SOUNDS+=HC55516@
SOUNDS+=OKIM6295@
OBJS += \
	$(OBJ)/machine/williams.o $(OBJ)/vidhrdw/williams.o $(OBJ)/sndhrdw/williams.o $(OBJ)/drivers/williams.o \
	$(OBJ)/machine/6821pia.o \
	$(OBJ)/machine/ticket.o \

endif

# MAME specific core objs
COREOBJS += $(OBJ)/tiny.o $(OBJ)/cheat.o
