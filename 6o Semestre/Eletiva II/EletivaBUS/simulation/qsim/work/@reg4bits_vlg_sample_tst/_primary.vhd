library verilog;
use verilog.vl_types.all;
entity Reg4bits_vlg_sample_tst is
    port(
        CLOCK           : in     vl_logic;
        IN_0            : in     vl_logic;
        IN_1            : in     vl_logic;
        IN_2            : in     vl_logic;
        IN_3            : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end Reg4bits_vlg_sample_tst;
