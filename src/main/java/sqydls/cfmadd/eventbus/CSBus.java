package sqydls.cfmadd.eventbus;

import com.mrcrayfish.furniture.tileentity.TileEntityModernSlidingDoor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sqydls.cfmadd.CFMAdditional;
import sqydls.cfmadd.block.BlockModernSlidingDoorRedStoneSupport;
import sqydls.cfmadd.item.ItemModernSlidingDoorRedStoneSupport;




@Mod.EventBusSubscriber(modid = CFMAdditional.MODID)
public class CSBus {

    public static final CreativeTabs EXAMPLE_CREATIVE_TAB = new CreativeTabs("CFMADD") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    // 自动门方块
    private static final Block block_bmsdrs = new BlockModernSlidingDoorRedStoneSupport().setRegistryName("cfmadd:modern_sliding_door_red_stone_support").setUnlocalizedName("modern_sliding_door_red_stone_support").setCreativeTab(EXAMPLE_CREATIVE_TAB);
    private static final Item item_bmsdrs =  new ItemModernSlidingDoorRedStoneSupport(block_bmsdrs).setRegistryName("cfmadd:modern_sliding_door_red_stone_support").setCreativeTab(EXAMPLE_CREATIVE_TAB).setUnlocalizedName("modern_sliding_door_red_stone_support");


    // 必须带static 否则不会被加载
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(block_bmsdrs);
    }

    @SubscribeEvent
    public static void registryItem(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(item_bmsdrs);
    }

    @SubscribeEvent
    public static void registerRender(ModelRegistryEvent event){
        // 让3d物品在背包或物品栏也渲染
        ModelLoader.setCustomModelResourceLocation(item_bmsdrs, 0, new ModelResourceLocation("cfmadd:" + item_bmsdrs.getUnlocalizedName().substring(5), "inventory"));
    }

    @SubscribeEvent
    public static void event(BlockEvent event){
        World world = event.getWorld();
        BlockPos pos = event.getPos();

        if (world.isBlockPowered(pos)){
            BlockPos up = pos.up();
            BlockPos down = pos.down();
            BlockPos east = pos.east();
            BlockPos west = pos.west();
            BlockPos north = pos.north();
            BlockPos south = pos.south();

            Block upBlock = world.getBlockState(up).getBlock();
            Block downBlock = world.getBlockState(down).getBlock();
            Block eastBlock = world.getBlockState(east).getBlock();
            Block westBlock = world.getBlockState(west).getBlock();
            Block northBlock = world.getBlockState(north).getBlock();
            Block southBlock = world.getBlockState(south).getBlock();

            if (upBlock instanceof BlockModernSlidingDoorRedStoneSupport){
                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) upBlock;
                TileEntity tileEntity = world.getTileEntity(up);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,up, true);
                    }

                }

            }

            if (downBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) downBlock;
                TileEntity tileEntity = world.getTileEntity(down);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,down, true);
                    }

                }
            }
            if (eastBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) eastBlock;
                TileEntity tileEntity = world.getTileEntity(east);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,east, true);
                    }

                }
            }
            if (westBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) westBlock;
                TileEntity tileEntity = world.getTileEntity(west);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,west, true);
                    }

                }
            }
            if (northBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) northBlock;
                TileEntity tileEntity = world.getTileEntity(north);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,north, true);
                    }

                }
            }
            if (southBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) southBlock;
                TileEntity tileEntity = world.getTileEntity(south);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (!powered){
                        bmsrs.setPowered(world,south, true);
                    }

                }

            }

        }else{

            BlockPos up = pos.up();
            BlockPos down = pos.down();
            BlockPos east = pos.east();
            BlockPos west = pos.west();
            BlockPos north = pos.north();
            BlockPos south = pos.south();

            Block upBlock = world.getBlockState(up).getBlock();
            Block downBlock = world.getBlockState(down).getBlock();
            Block eastBlock = world.getBlockState(east).getBlock();
            Block westBlock = world.getBlockState(west).getBlock();
            Block northBlock = world.getBlockState(north).getBlock();
            Block southBlock = world.getBlockState(south).getBlock();

            if (upBlock instanceof BlockModernSlidingDoorRedStoneSupport){
                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) upBlock;
                TileEntity tileEntity = world.getTileEntity(up);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,up, false);
                    }

                }

            }

            if (downBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) downBlock;
                TileEntity tileEntity = world.getTileEntity(down);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,down, false);
                    }

                }
            }
            if (eastBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) eastBlock;
                TileEntity tileEntity = world.getTileEntity(east);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,east, false);
                    }

                }
            }
            if (westBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) westBlock;
                TileEntity tileEntity = world.getTileEntity(west);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,west, false);
                    }

                }
            }
            if (northBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) northBlock;
                TileEntity tileEntity = world.getTileEntity(north);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,north, false);
                    }

                }
            }
            if (southBlock instanceof BlockModernSlidingDoorRedStoneSupport){

                BlockModernSlidingDoorRedStoneSupport bmsrs = (BlockModernSlidingDoorRedStoneSupport) southBlock;
                TileEntity tileEntity = world.getTileEntity(south);
                if (tileEntity instanceof TileEntityModernSlidingDoor){
                    boolean powered = ((TileEntityModernSlidingDoor) tileEntity).isPowered();
                    if (powered){
                        bmsrs.setPowered(world,south, false);
                    }

                }

            }


        }

    }


}
