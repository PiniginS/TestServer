package server.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
public class CategoryController {

    @RequestMapping(value = "/testData", method = RequestMethod.GET)
    @ResponseBody
    public String generator(@RequestParam(value = "type", required = false, defaultValue = "empty") String type) {
        JSONObject response = new JSONObject();
        switch (type) {
            case "category":
                response = genCategory();
                break;
            case "items":
                response = genItems();
                break;
            case "randomItems":
                response = genRandomItems();
                break;
            default:
                response = new JSONObject();
        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return response.toString();
    }

    private JSONObject genCategory() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            System.out.println(Paths.get(cl.getResource("categorys.json").getFile()));
            String content = new String(Files.readAllBytes(Paths.get(cl.getResource("categorys.json").getFile())));
            return new JSONObject(content);
        } catch (JSONException e) {
            System.out.println("genCategory json error");
        } catch (IOException e) {
            System.out.println("genCategory file not found");
        }
        return new JSONObject();
    }

    private JSONObject genItems() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            System.out.println(Paths.get(cl.getResource("items.json").getFile()));
            String content = new String(Files.readAllBytes(Paths.get(cl.getResource("items.json").getFile())));
            return new JSONObject(content);
        } catch (JSONException e) {
            System.out.println("genItems json error");
        } catch (IOException e) {
            System.out.println("genItems file not found");
        }
        return new JSONObject();
    }

    private JSONObject genRandomItems() {
        List<String> images = Arrays.asList("https://ae01.alicdn.com/kf/HTB1PDLAOFXXXXXQXpXXq6xXFXXXi/Bathroom-shower-head-300-hole-Smooth-water-flow-Chrome-abs-rain-shower-head-16.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB18X7USFXXXXXtXpXXq6xXFXXXL/D-K-Bathroom-font-b-Shower-b-font-Faucets-with-Long-Spout-Set-Single-Handle-Bathtub.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1JCTNRVXXXXaTapXXq6xXFXXXD/Rolecos-Brand-American-TV-Series-Game-of-Thrones-Cosplay-Costume-Jon-Snow-Cosplay-Knight-Role-Play.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1ELmYX6S_LeJjSZFxq6yP8XXaN/Sexy-Game-OW-D-VA-Cosplay-Costume-One-Piece-Swimwear-Swimsuit-SUKUMIZU-S-L.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1HitGJpXXXXXQXVXXq6xXFXXXp/Assassin-s-Creed-IV-4-Black-Flag-Edward-Kenway-Cosplay-Costume-Whole-Set-Custom-Made-Express.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB15BEsSXXXXXXaXpXXq6xXFXXX4/spider-man-homecoming-Red-Black-Spiderman-Costume-Spider-Man-Suit-Spider-man-Costumes-Adults-Children-Kids.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1PHjAKVXXXXX4XpXXq6xXFXXXy/100-Original-Banpresto-JEANS-FREAK-Vol-3-Collection-Figure-Nico-Robin-Purple-Ver-from-One-Piece.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1Y7XJRVXXXXXDXXXXq6xXFXXXh/Banpresto-DXF-One-Piece-Perona-PVC-Figure-One-Piece-Jeans-Freak-Vol-5-Perona-Collectible-Model.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1rqMDRFXXXXXdXpXXq6xXFXXX2/New-Fashion-3-pcs-Christmas-Stocking-Santa-Claus-Snowman-Reindeer-Gift-Sock-Ornament-Socks-Christmas-Decoration.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1RVZUNpXXXXblaXXXq6xXFXXXE/BAVIRON-New-Fashion-Polarized-Cat-Eye-Sunglasses-Women-White-Frame-Gradient-Sun-Glasses-Diving-UV400-Aluminium.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1beXxbaagSKJjy0Faq6z0dpXa1/ANDYJOY-Brand-Design-Women-Luxury-Crystal-Sunglasses-Square-Shape-Female-Oversized-Sun-font-b-Glasses-b.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1DYUhPVXXXXamaXXXq6xXFXXXL/PG629-Limited-Jabba-Star-Wars-The-Hut-Dolls-Building-Blocks-Action-Figure-The-Hutt-Version-Best.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB19a6ZSXXXXXc2XVXXq6xXFXXXR/Hot-World-War-Mini-Military-figure-blocks-Soviet-soldiers-Red-Army-War-arms-guns-compatible-with.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB107OiSpXXXXXRXFXXq6xXFXXXH/Promotion-Star-Wars-Action-Figure-Toys-Jedi-Knight-Master-Yoda-PVC-Figures-Toys-12cm-Children-Birthday.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1TTDyLFXXXXa2aXXXq6xXFXXXB/FREE-SHIPPING-2016-new-T-touch-colorful-BB8-star-font-b-wars-b-font-light-holiday.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1ltrGSpXXXXbvapXXq6xXFXXXN/Breast-Silicone-Boob-Form-Perfect-Realistic-font-b-Toys-b-font-for-Male-Artificial-Safety-Teardrop.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1n0niQVXXXXX0XXXXq6xXFXXXP/Kids-Animal-Puzzle-Educational-Toys-Airplane-Kids-Disassembly-Assembly-Cartoon-Toy-Aircraft.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1zoIaNVXXXXbBXpXXq6xXFXXXi/Christmas-Toys-pllow-Valentines-Gift-Led-Light-Pillow-plush-Pillow-Hot-Colorful-Stars-kids-Toys-Birthday.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB14oYsSpXXXXbcXXXXq6xXFXXXI/Stuffed-Toys-Lovely-Simulation-Animal-Doll-Plush-Sleeping-Cats-Toy-with-Sound-Kids-Toy-Decorations-Birthday.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB15xvuNpXXXXa7aXXXq6xXFXXXI/DHL-KF1008-Avengers-Superheroes-Captian-America-Catwoman-Penguin-Strange-Moon-Knight-Joker-Batman-Minifigures-Toys-Kids.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1d_qmSXXXXXX5aFXXq6xXFXXXs/4Pcs-set-Minecraft-Sword-Espada-Models-Figures-Building-Blocks-Model-Set-Figures-Compatible-Legoes-Toys-Gifts.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1XTJ6PpXXXXahXXXXq6xXFXXXi/Jurassic-World-Park-Tyrannosaurus-Rex-Dinosaur-Plastic-Toy-Model-Kids-Gifts.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1RIgCLXXXXXa0XXXXq6xXFXXXH/2016-Hot-Baby-Infant-Animal-Soft-Rattles-Bed-Crib-Stroller-Music-Hanging-Bell-Toy-Dog-Baby.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1W7p.RXXXXXXhapXXq6xXFXXXk/Game-animation-color-bird-creative-cartoon-cute-animal-doll-toy-doll-gift.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1zcSoLVXXXXcLXVXXq6xXFXXXG/Luminous-pillow-Christmas-Toys-Led-Light-Pillow-plush-Pillow-Hot-Colorful-Stars-kids-Toys-Free-Shipping.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1quBqQVXXXXXoXVXXq6xXFXXXz/Soom-imda-3-0-Colette-bjd-sd-dolls-1-6-body-model-reborn-girls-boys-eyes.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1jLY6cC7PL1JjSZFHq6AciXXaM/Yeston-NVIDIA-GeForce-GTX-1050-Ti-GPU-4GB-GDDR5-128-bit-Gaming-Desktop-computer-PC-support.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1zZ3PXe2CK1JjSZFrq6zHFpXaF/Yeston-Radeon-R7-200-Series-R7-240-GPU-4GB-GDDR5-128bit-Gaming-Desktop-PC-Video-font.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1QCwLbq_ST1JjSZFqq6AQxFXaP/Original-GPU-Veineda-font-b-Graphic-b-font-font-b-card-b-font-HD6850-2GB-GDDR5.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1GkaYSpXXXXbYXFXXq6xXFXXXM/Original-GAOMON-860T-8-Inch-Digital-Tablets-USB-Drawing-Tablet-Support-TF-font-b-Card-b.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1WFVKSFXXXXcLaXXXq6xXFXXXp/gpu-VGA-cooler-font-b-graphics-b-font-gtx1080-gtx980ti-gtx1060-gtx1070-fan-for-ASUS-STRIX.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1Egjebs2vU1JjSZFwq6x2cpXaj/2017-orbea-fahrradbekleidung-sommer-ropa-ciclismo-hombre-neue-ankunft-bike-cycling-jersey-font-b-sport-b.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1u64ARpXXXXbkXFXXq6xXFXXX7/2017-Summer-short-sleeve-t-shirt-men-gyms-font-b-sporting-b-font-fashion-tshirt-homme.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1o8TxRXXXXXaxXVXXq6xXFXXXj/Factory-Direct-Sales-Free-Shipping-3pcs-lot-208-cm-Resistance-Expander-Bands-Exercise-font-b-Sporting.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1cFjmfQ.HL1JjSZFuq6x8dXXan/BOZLUN-Men-Smart-Watch-font-b-Sports-b-font-Pedometer-Watches-Call-Reminder-Digital-Watches-30M.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1PmG0bjihSKJjy0Feq6zJtpXac/2018-Brand-New-MAKOSHARK-Pro-Cycling-Jerseys-Short-Sleeves-And-Bib-Shorts-Cycling-Sets-Bicicleta-Sportswear.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1Gvv2QVXXXXbyaXXXq6xXFXXXf/VECTOR-Professional-Child-Ski-Jackets-Winter-Warm-Waterproof-Boys-Girls-Jackets-Outdoor-Sport-Snow-Skiing-Snowboarding.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1QYheOXXXXXcJapXXq6xXFXXXE/Cycling-gloves-mtb-full-finger-winter-autumn-waterproof-touch-screen-road-mountain-bike-bicycle-gloves-gel.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1RUyKdUF7MKJjSZFLq6AMBVXaU/Genuine-CHCUM-Silk-Dots-Children-Bow-Tie-Classical-Business-Bow-Ties-For-Men-2017-Dress-font.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1JD17X2MTUeJjSZFKq6ygopXaQ/Autumn-font-b-clothing-b-font-New-product-Sweater-Strapless-long-sleeves-Hooded-sweater-woman-Europe.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1VhdsSFXXXXXmaXXXq6xXFXXXl/Winter-Outdoor-Camping-Hiking-Jackets-Couple-Waterproof-font-b-Clothing-b-font-Warm-Padded-Jackets-Triple.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1eY.Kd8cHL1JjSZJiq6AKcpXax/Yilia-Plus-Size-Dresses-XXXL-Autumn-Winter-Women-2017-Sleeve-Sexy-Black-Party-Embroidery-Short-Pencil.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1K3WFPpXXXXbGaXXXq6xXFXXXn/Original-Mobile-font-b-Phone-b-font-YUNSONG-S9-Plus-16MP-camera-6-0-inch-Smartphone.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1aGkzSpXXXXaSXVXXq6xXFXXXw/LeEco-Le-X626-Letv-S3-Mobile-font-b-Phone-b-font-MTK-Helio-X20-5-5.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1jYyhSVXXXXcfXFXXq6xXFXXXy/E-L-W9-4G-Mobile-font-b-Phone-b-font-6-0-inch-Waterproof-Shockproof-IP68.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1w2I.OVXXXXayXVXXq6xXFXXX7/Touchscreen-Programmable-Wifi-Thermostat-for-Water-Floor-Heating-Controlled-by-Smart-font-b-Phone-b-font.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1SgWjSVXXXXX2XVXXq6xXFXXX5/HOT-10-Pack-Lot-1-4-6-3mm-TS-Right-Angle-MONO-font-b-Phone-b.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1GXKkbOERMeJjSspiq6zZLFXaQ/GUSGU-fashion-font-b-phone-b-font-case-protective-Shell-for-apple-iPhone-7-non-slip.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1s2AkSXXXXXXoXFXXq6xXFXXXe/5V-4-2A-Dual-USB-Car-font-b-Phone-b-font-Charger-Fast-Charging-USB-Smart.jpg_220x220.jpg","https://ae01.alicdn.com/kf/HTB1beb9Xv_HK1Jjy1zcq6xb7XXaC/Umidigi-Crystal-4G-Borderless-Mobile-font-b-Phone-b-font-5-5-Inch-FHD-MTK6737T-Quad.jpg_220x220.jpg");
        List<String> urls = Arrays.asList("https://ru.aliexpress.com/item/Bben-fan-intel-mini-pc-windows-10-4Gb-RAM-64Gb-emmc-mini-pc-Portable-Computer-pc/32694326348.html","https://ru.aliexpress.com/item/CHUWI-Mini-PC-HiBox-hero-Intel-X5-Z8350-4GB-RAM-64GB-ROM-Android-5-1-Window10/32791839597.html","https://ru.aliexpress.com/item/Intel-I7-6700HQ-GTX960M-4G-Graphics-Mini-PC-Windows-10-Desktop-Computer-Pocket-PC-barebone-system/32829412746.html","https://ru.aliexpress.com/item/small-desktop-computers-QOTOM-Q100-all-in-one-pc-mini-itx-mini-pc-smart-mini-pc/1611590485.html","https://ru.aliexpress.com/item/1080p-hdmi-mini-silent-pc-Qotom-Q100-S02-intel-celeron-1-8G-8G-RAM-500G-HDD/1568102416.html","https://ru.aliexpress.com/item/Android-2D-Barcode-Scanner-Smart-Phone-UHF-915M-PDA-RFID-ablet-PC/32247265245.html","https://ru.aliexpress.com/item/Fanless-Mini-PC-Desktop-Computer-tv-box-Windows-10-TV-box-raspberry-pi-Core-i5-7200U/32789632183.html","https://ru.aliexpress.com/item/New-VOYO-VMac-Mini-PC-Intel-Apollo-N3450-License-Windows-10-Pocket-PC-4GB-DDR3L/32788223771.html","https://ru.aliexpress.com/item/X5-Dual-system-Mini-PC-Intel-Atom-X5-Z8350-2GB-32GB-Windows-10-Android-5-1/32832791705.html","https://ru.aliexpress.com/item/Smart-DLP-Portable-Projector-Tablet-2-in-1-LED-mini-micro-projector-Android-8-Inch-3G/32831898825.html","https://ru.aliexpress.com/item/MAIKES-new-design-vintage-genuine-cow-leather-watchbands-watch-accessory-bracelet-for-apple-watch-band-42mm/32812028636.html","https://ru.aliexpress.com/item/Maikes-genuine-leather-black-16mm-18mm-19mm-20mm-21mm-22mm-24mm-watch-bands-good-quality-watch/32332135352.html","https://ru.aliexpress.com/item/FOHUAS-National-style-Floral-Printed-Leather-Watch-Band-Strap-for-Apple-Watch-Flower-Design-Wrist-Watch/32829094891.html","https://ru.aliexpress.com/item/CHIMAERA-Black-Brown-Coffee-Genuine-leather-watch-band-for-Apple-watch-with-Spring-bar-adapter-Link/32750670124.html","https://ru.aliexpress.com/item/Solid-316L-Stainless-Steel-Watchbands-Silver-18-20-21-22-23-24mm-Metal-Watch-Band-Strap/32810722297.html","https://ru.aliexpress.com/item/Bemorcabo-for-20mm-Garmin-Fenix-5-GPS-Quick-Release-Strap-Easy-Fit-Silicone-Replacement-Watch-Band/32828829529.html","https://ru.aliexpress.com/item/CHIMAERA-23mm-T035617-T035439-Watchband-316L-Silver-Solid-Stainless-Steel-Watch-strap-for-Tissot-couturier-T035/32705361036.html","https://ru.aliexpress.com/item/FOHUAS-Frosted-leather-Wrist-Strap-for-Samsung-Gear-S3-Frontier-Silicone-Watch-Band-for-Samsung-Gear/32827916113.html","https://ru.aliexpress.com/item/Wholesale-1000PCS-bag-watch-for-parts-Plastic-card-seconds-0-5mm-0-6mm-0-7mm-0/32768597858.html","https://ru.aliexpress.com/item/Wholesale-1440PCS-bag-10-gross-fingertip-Finger-sets-watch-repair-Latex-gloves-WP0099/32359373971.html","https://ru.aliexpress.com/item/Bonsny-Statement-Metal-Alloy-Enamel-Animal-Pets-Dachshund-Dog-Choker-Necklace-Chain-Collar-Pendant-Fashion-New/32733503414.html","https://ru.aliexpress.com/item/17KM-Boho-Collar-Choker-Water-Drop-Crystal-Beads-Choker-Necklace-pendant-Vintage-Simulated-Pearl-Statement-Beads/32780202015.html","https://ru.aliexpress.com/item/natural-stone-crystal-pillar-Pendants-necklaces-for-making-Jewelry-fahsion-mixed-charm-Point-pendant-24pcs-lot/32693565065.html","https://ru.aliexpress.com/item/Free-Shipping-Fashion-Design-Chunky-Bubblegum-Beads-Necklace-Moana-Pendant-New-Movie-Gift-Necklace-CDNL-410775/32805714634.html","https://ru.aliexpress.com/item/Game-of-Throne-Dragon-Punk-Luminous-Dragon-Pendants-Necklaces-Glow-in-the-Dark-Amulet-Sweater-Chain/32809889418.html","https://ru.aliexpress.com/item/Silver-chain-Modern-girl-new-long-necklace-women-pendants-2015-fashion-jewelry-wholesale/32489097696.html","https://ru.aliexpress.com/item/Choker-Necklaces-Pendants-For-Women-Snake-Chain-Gold-Plated-Silver-Plated-Zircon-Round-Star-For-Party/32741413750.html","https://ru.aliexpress.com/item/Beadsnice-sterling-silver-jewelry-findings-wholesale-useful-diy-necklace-orchid-jewelry-flower-connectors-pendant-ID31042/32306067095.html","https://ru.aliexpress.com/item/New-Gold-Plated-Balance-Wood-Straight-Bar-Alloy-Clavicle-snake-Pendant-Short-Necklace/32795321059.html","https://ru.aliexpress.com/item/Karma-Gold-Plated-Three-Ring-Necklace/32796456412.html","https://ru.aliexpress.com/item/Oslamp-H4-LED-Car-Headlight-Bulb-Hi-Lo-Beam-Auto-Headlamp-72W-8000LM-COB-Led-Headlights/32698331999.html","https://ru.aliexpress.com/item/CNSUNNYLIGHT-Waterproof-Car-High-Power-Aluminum-LED-Daytime-Running-Lights-with-Lens-DC12v-Xenon-White-1set/32656580766.html","https://ru.aliexpress.com/item/Super-Bright-Car-Headlights-H7-LED-H1-H3-H11-9005-HB4-9006-70W-7000lm-Auto-Front/32797012107.html","https://ru.aliexpress.com/item/DBPOWER-2PCS-Car-Headlight-H4-H7-LED-H8-H11-HB3-9005-HB4-9006-H1-H3-9012/32823308167.html","https://ru.aliexpress.com/item/OEM-Hella-HID-Xenon-Ballast-for-A-udi-B-MW-J-aguar-M-ercedes-S-aab/32809261287.html","https://ru.aliexpress.com/item/New-Valeo-LAD5GL-4Pin-D1S-D1R-D2S-D2R-Xenon-Headlight-Control-Unit-Ballast-ECU-reactor-4/32809173571.html","https://ru.aliexpress.com/item/2pcs-Car-20W-Led-Work-Light-12V-24V-Offroad-Spot-Beam-Universal-Motorcycle-Bicycle-Driving-Lamp/32812993025.html","https://ru.aliexpress.com/item/Super-Bright-LED-Car-Headlights-H7-H8-H11-H1-HB3-9005-HB4-9006-H3-880-35W/32700432122.html","https://ru.aliexpress.com/item/2x-H4-H7-H13-H11-9005-9006-COB-LED-Headlight-72W-8000LM-All-In-One-Car/32749693992.html","https://ru.aliexpress.com/item/2PCS-H7-LED-H4-H11-H1-H3-9005-9006-COB-S2-Auto-Car-Headlight-72W-8000LM/32820004133.html","https://ru.aliexpress.com/item/DOOGEE-X5-Max-Pro-2GB-16GB-MTK6737-X5-Max-1GB-8GB-MTK6580-5-0-Android-6/32804441707.html","https://ru.aliexpress.com/item/Original-LEAGOO-M8-3G-Mobile-Phone-Android-6-0-MTK6580A-Quad-Core-1-3GHz-RAM-2GB/32772354059.html","https://ru.aliexpress.com/item/New-headphones-children-cartoon-cute-cat-ears-wearing-light-emitting-collapsible-music-headphones-for-a-mobile/32807183008.html","https://ru.aliexpress.com/item/Oukitel-C9-18-9-Full-Display-Mobile-Phone-5-5-HD-Quad-Core-2GB-RAM-16GB/32831094386.html","https://ru.aliexpress.com/item/Leagoo-Kiicaa-Power-Mobile-Phone-4000-mAh-Android-7-0-2GB-16GB-Quad-Core-Smartphone-Dual/32832319808.html","https://ru.aliexpress.com/item/E-L-W5S-Mobile-Phone-Waterproof-Shockproof-IP68-Android-6-0-Quad-Core-1GB-RAM-8GB/32832748523.html","https://ru.aliexpress.com/item/GUSGU-Universal-Flexible-Holder-Arm-Lazy-Mobile-Phone-Stand-Holder-Clip-Bracket-Bed-Desk-Stents-For/32828973191.html","https://ru.aliexpress.com/item/LCD-Display-Assembly-with-Frame-For-Huawei-Mate-9-MHA-L09-L29-with-Touch-Screen-Mobile/32802231122.html","https://ru.aliexpress.com/item/E-L-W9-4G-Mobile-Phone-6-0-inch-Waterproof-Shockproof-IP68-Android-6-0-MTK6753/32829167615.html","https://ru.aliexpress.com/item/2016-GSM-booster-with-LCD-DISPLAY-mobile-phone-GSM-signal-repeater-GSM-900mhz-signal-amplifier-with/32755164362.html","https://ru.aliexpress.com/item/2017-Spring-Floral-Print-Men-Shirts-Long-Sleeve-Mens-Casual-Shirt-Slim-Men-Flower-Printing-Dress/32793035218.html","https://ru.aliexpress.com/item/MENS-VINTAGE-PLAID-CHECK-LONG-SLEEVE-SHIRT-slim-fit-shirts-for-men-High-Quality-T-SHIRT/1724897752.html","https://ru.aliexpress.com/item/HEYKESON-Men-Shirt-Brand-2017-Male-High-Quality-Long-Sleeve-Shirts-Casual-Hit-Color-Slim-Fit/32819593788.html","https://ru.aliexpress.com/item/Free-Shipping-New-2014-Men-Casual-Plaid-Shirt-Long-Sleeve-Cotton-Slim-Fit-Flannel-Man-Clothes/2050986994.html","https://ru.aliexpress.com/item/Men-Shirt-Luxury-Brand-2016-Male-Long-Sleeve-Shirts-Casual-Solid-Multi-Button-Hit-Color-Slim/32706106291.html","https://ru.aliexpress.com/item/QINGYU-Men-Shirt-Brand-2017-Male-High-Quality-Long-Sleeve-Shirts-Casual-Hit-Color-Slim-Fit/32806233376.html","https://ru.aliexpress.com/item/free-shipping-new-2015-autumn-spring-mens-casual-shirts-long-sleeve-100-cotton-dress-shirt-men/32420313364.html","https://ru.aliexpress.com/item/TACVASEN-Men-s-Brand-Tactical-Quick-Drying-Shirt-Breathable-Camp-Casual-Long-Sleeve-Shirt-Men-Combat/32821862608.html","https://ru.aliexpress.com/item/4XL-5XL-6XL-7XL-8XL-Large-Size-Men-s-Business-Casual-Long-Sleeved-Shirt-White-Blue/32633561482.html","https://ru.aliexpress.com/item/2015-New-Autumn-Fashion-Brand-Men-Clothes-Slim-Fit-Men-Long-Sleeve-Shirt-Men-Plaid-100/32434105168.html","https://ru.aliexpress.com/item/Simplee-Halter-backless-summer-dress-women-Floral-print-beach-dresses-split-long-dress-Elegant-sexy-maxi/32807268865.html","https://ru.aliexpress.com/item/BerryGo-Floral-print-halter-chiffon-long-dress-Women-backless-2017-maxi-dresses-vestidos-Sexy-white-split/32794562664.html","https://ru.aliexpress.com/item/Catwalk-High-Quality-Designer-Runway-2017-Autumn-Beach-Boho-Party-Women-s-Office-Folded-hollow-out/32831486065.html","https://ru.aliexpress.com/item/New-Women-s-Maxi-Long-Dubai-Dress-moroccan-Kaftan-Caftan-Jilbab-Islamic-Abaya-Muslim-Turkish-Middle/32703717978.html","https://ru.aliexpress.com/item/Bonas-1985-Velvet-Dress-Trendy-Side-Split-Floral-Embroidery-Mid-Sleeve-Black-Vestidos-Elbise-Women-Vintage/32823142695.html","https://ru.aliexpress.com/item/2017-Summer-Lace-Sexy-Sleeveless-O-neck-Chandelier-Chic-Lace-Decorative-Slim-Dress-Party-Dresses-OSM0307/32798018282.html","https://ru.aliexpress.com/item/Club-Long-Sleeve-Sexy-Nightclothes-Slim-Dress-in-Fallen-European-Station-Bandage-Skirt/32827806878.html","https://ru.aliexpress.com/item/Maxi-Dress-Fashion-Sexy-Lace-Dress-Two-Piece-Black-Long-Sleeve-Elegant-Vintage-Dress-Cheap-Chiffon/32744635159.html","https://ru.aliexpress.com/item/Bonas1985-S-6XL-Floral-Dress-Women-Short-Sleeve-Off-Shoulder-Beach-Dresses-Plus-Size-Female-Summer/32828340004.html","https://ru.aliexpress.com/item/Will-spot-the-new-8025-European-heavy-industry-A-word-long-red-dress-dress-embroidered-the/32819053212.html");
        JSONObject response = new JSONObject();
        JSONArray items = new JSONArray();
        for (int i = 0; i < (int)(Math.random() * 90+10); i++) {
            JSONObject item = new JSONObject();
            int id = (int)(Math.random() * 999999);
            int discountPercent = (int)(Math.random() * 100);
            int basicPrice = (int)(Math.random() * 999999);
            int price = (int)(basicPrice - basicPrice*discountPercent/100);
            int discount = basicPrice - price;
            String name = genName();
            int ratingStore = (int)(Math.random() * 100);
            int trade = (int)(Math.random() * 9999);
            item.put("id", String.valueOf(id));
            item.put("img", images.get((int)(Math.random() * 50)));
            item.put("subject", name);
            item.put("price", String.valueOf(price));
            item.put("discount", String.valueOf(discount));
            item.put("discountPercent", String.valueOf(discountPercent));
            item.put("ratingStore", String.valueOf(ratingStore));
            item.put("trade", String.valueOf(trade));
            item.put("url",urls.get((int)(Math.random() * 70)));
            items.put(item);
        }
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("data",items);
        response.put("result",result);
        return response;
    }

    public String genName() {

        List<String> name = Arrays.asList("зуб","смерть","цветок","объект","заявление","капитан","последствие","перевод","название","фотография","мера","потолок","дверь","знание","оплата","больница","проблема","июнь","деталь","разница","занятие","произведение","множество","ставка","планета","человечество","удар","команда","плата","язык","жертва","остров","доска","обсуждение","народ","небо","автор","читатель","корень","степень");
        List<String> name2 = Arrays.asList("одинаковый","капитальный","персональный","телевизионный","колючий","районный","универсальный","деловой","уникальный","неплохой","потенциальный","адекватный","немой","решающий","известный","сумасшедший","сухой","молодежный","жизненный","необычный","популярный","немалый","гражданский","ничтожный","нормальный","нормативный","турецкий","ленинградский","металлический","питерский","квадратный","поперечный","уполномоченный","особенный","ночной","общий","печатный","вкусный","локальный","профессиональный");
        List<String> name3 = Arrays.asList("попасть","охранять","благодарить","кинуться","представлять","оплачивать","отмечать","повышать","обвинять","создавать","говорить","уделять","выхаживать","закреплять","заменять","касаться","висеть","предпчитать","умирать","гарантировать","заявлять","состоять","стучать","наблюдаться","присутствовать","оствить","пройти","присылать","заняться","лишать","целовать","измениться","отказывать","исчезнуть","жалеь","разговаривать","последовать","допускать","стремиться","сокращать");
        List<List<String>> names= Arrays.asList(name,name2,name3);
        String subject="";
        for (int i=0;i<(int)(Math.random()*3+2);i++) {
            for (int g=0;g<(int)(Math.random()*3+2);g++) {
                subject+=names.get((int)(Math.random()*3)).get((int)(Math.random()*40))+" ";
            }
        }
        return subject;
    }
}

