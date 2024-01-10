import asyncio

async def do():
    await asyncio.sleep(1)
    
async def main():
    await asyncio.gather(do(), do(), do())
    
if __name__ == '__main__':
    import time 
    s = time.perf_counter()
    asyncio.run(main())
    elapsed = time.perf_counter() - s
    print(f'Executed in {elapsed:.0f} seconds')